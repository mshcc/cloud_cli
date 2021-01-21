package com.mshcc.cloud.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mshcc.cloud.gateway.config.resource.GatewayResourceFactory;
import com.mshcc.cloud.gateway.config.resource.Resource;
import com.mshcc.cloud.gateway.utils.EncryptUtil;
import com.mshcc.cloud.gateway.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mshcc
 * @Date 2021/1/12 10:26
 * @Description TODO 自定义全局过滤器，完成统一授权认证。约定资源名=url前缀
 *                  可以修改规则，将配置文件中的 资源-权限列表 修改为 资源-url列表
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Autowired
    private GatewayResourceFactory gatewayResourceFactory;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath().trim();
        path = path.split(StringUtil.PATH_SPLIT)[1];
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (path.equals(StringUtil.UAA_PATH)) {
            // TODO uaa授权模块全面放行   还有一些前台资源  (后续考虑将无需权限的路径放在数据库中，读取后放行)
            return chain.filter(exchange);
        }
        Resource[] resources = gatewayResourceFactory.getResources();
        for (Resource resource : resources) {
            if (resource.getResourceName().equals(path)) {
                // TODO 从token中解析用户信息
                String realToken = token.replace("Bearer ", "");
                Jwt jwt = JwtHelper.decode(realToken);
                String claims = jwt.getClaims();
                Map<String, Object> map = (Map<String, Object>) JSON.parse(claims);
                // TODO 取出用户身份信息
                String userStr = (String) map.get("user_name");
                JSONArray authoritiesArray = (JSONArray) map.get("authorities");
                String[] authorities = authoritiesArray.toArray(new String[authoritiesArray.size()]);
                Map<String, Object> jsonToken = new HashMap<>(8);
                jsonToken.put("principal", userStr);
                jsonToken.put("authorities", authorities);
                // TODO aud为该客户端可访问资源，暂时没用上(实现方式思路问题)
                JSONArray audArray = (JSONArray) map.get("aud");
                String[] aud = audArray.toArray(new String[audArray.size()]);
                jsonToken.put("aud", aud);
                Object clientId = map.get("client_id");
                jsonToken.put("client_id", clientId);
                JSONArray scopeArray = (JSONArray) map.get("scope");
                String[] scopes = scopeArray.toArray(new String[scopeArray.size()]);
                jsonToken.put("scope", scopes);
                // TODO 查询ROLE，比对是否有权限访问该资源
                if(compare(resource.getRoles(),scopes)){
                    // TODO 把身份信息和权限信息放在json中，加入http的header中,转发给微服务
                    ServerHttpRequest host = exchange.getRequest().mutate()
                            .header("json-token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)))
                            .build();
                    ServerWebExchange build = exchange.mutate().request(host).build();
                    return chain.filter(build);
                }else {
                    // TODO 没有查询到资源所需权限，中止该次查询
                    ServerHttpResponse response = exchange.getResponse();
                    response.getHeaders().add("Content-type", "application/json;charset=utf-8");
                    response.setStatusCode(HttpStatus.FORBIDDEN);
                    return response.writeWith(Mono.just(response.bufferFactory().wrap("没有权限访问".getBytes())));
                }
            }
        }
        // TODO 没有查询到资源所需权限，中止该次查询
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-type", "application/json;charset=utf-8");
        response.setStatusCode(HttpStatus.NOT_FOUND);
        return response.writeWith(Mono.just(response.bufferFactory().wrap("请求的资源不存在或未定义，请检查url或联系管理员".getBytes())));
    }



    // TODO 比较SCOPE和资源所需rule

    private boolean compare(String[] rules,String[] demand){
        for (String rule : rules) {
            for (String s : demand) {
                if(s.equals(rule)){
                    return true;
                }
            }
        }
        return false;
    }
    // TODO gateway过滤器链根据orderId进行排序，越小则优先级越高

    @Override
    public int getOrder() {
        return -999;
    }
}
