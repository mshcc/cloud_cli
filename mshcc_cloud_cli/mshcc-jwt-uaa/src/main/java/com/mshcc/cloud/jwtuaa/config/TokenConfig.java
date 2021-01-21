package com.mshcc.cloud.jwtuaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author mshcc
 * @Date 2021/1/5 11:02
 * @Description TODO 令牌存储策略
 */
@Configuration
public class TokenConfig {
    private String SIGNING_KEY="uaa123";
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
        jwt.setSigningKey(SIGNING_KEY);
        return jwt;
    }
}
