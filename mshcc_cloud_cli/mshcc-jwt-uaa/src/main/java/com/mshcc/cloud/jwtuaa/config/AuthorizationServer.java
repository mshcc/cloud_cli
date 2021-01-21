package com.mshcc.cloud.jwtuaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author mshcc
 * @Date 2021/1/5 10:39
 * @Description TODO
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private DataSource dataSource;
    // TODO 配置客户端详情

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    /*        // TODO 使用内存模拟
        clients.inMemory()
                // TODO 客户端id
                .withClient("c1")
                // TODO 设置客户端密钥
                .secret(passwordEncoder.encode("admin"))
                // TODO 指定客户端可以访问什么资源
                .resourceIds("res1", "res2")
                // TODO 允许的授权类型
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                // TODO 允许的授权范围
                .scopes("all")
                .autoApprove(false)
                // TODO 验证回调地址
                .redirectUris("http://www.baidu.com");*/
        clients.withClientDetails(jdbcClientDetailsService());
    }
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        JdbcClientDetailsService service = new JdbcClientDetailsService(dataSource);
        service.setPasswordEncoder(passwordEncoder);
        return service;
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }


    // TODO 配置授权码服务

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    // TODO 授权服务器令牌服务

    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        // TODO 令牌存储策略
        services.setTokenStore(tokenStore);
        // TODO 客户端信息服务
        services.setClientDetailsService(jdbcClientDetailsService());
        // TODO 是否刷新令牌
        services.setSupportRefreshToken(true);

        // TODO 令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);
        // TODO 设置令牌默认有效期 2h
        services.setAccessTokenValiditySeconds(7200);
        // TODO 刷新令牌默认有效期 3天
        services.setRefreshTokenValiditySeconds(259200);

        return services;
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager);
        endpoints.accessTokenConverter(jwtAccessTokenConverter);
        endpoints.authorizationCodeServices(authorizationCodeServices());
    }



}