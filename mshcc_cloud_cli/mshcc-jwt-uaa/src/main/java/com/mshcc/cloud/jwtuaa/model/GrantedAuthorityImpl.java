package com.mshcc.cloud.jwtuaa.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author mshcc
 * @Date 2021/1/4 14:28
 * @Description TODO 用于授权使用，存储权限
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}