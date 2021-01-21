package com.mshcc.cloud.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author mshcc
 * @Date 2021/1/14 13:37
 * @Description TODO
 */
@Configuration
public class GatewayConfiguration {

    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public GatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    // TODO 限流处理器
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        // Register the block exception handler for Spring Cloud Gateway.
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    // TODO 限流过滤器
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }

    @PostConstruct
    public void doInit() {
//        initGatewayRoles();
        initBlockHandler();
    }

    private void initGatewayRoles() {
        Set<GatewayFlowRule> rules = new HashSet<>();
        rules.add(new
                // TODO 资源/API名称 网关id
                GatewayFlowRule("security-order")
                // TODO 阈值 60s内3次
                .setCount(3)
                .setIntervalSec(60));

        GatewayRuleManager.loadRules(rules);
    }
    private void initBlockHandler(){
        BlockRequestHandler blockRequestHandler = (serverWebExchange, throwable) -> {
            Map<String, String> result = new HashMap<>();
            result.put("code",String.valueOf(HttpStatus.TOO_MANY_REQUESTS.value()));
//            result.put("message",HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());
            result.put("message","{\n\t\"status\":429,\n\t\"msg\": \"你的访问太过频繁\",\n\t\"data\": {\n\n\t\t}\n}");
            result.put("route","order");
            return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromObject(result));
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}