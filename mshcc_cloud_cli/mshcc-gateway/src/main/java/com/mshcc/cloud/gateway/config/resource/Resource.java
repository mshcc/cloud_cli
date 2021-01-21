package com.mshcc.cloud.gateway.config.resource;

import java.util.Arrays;

/**
 * @author mshcc
 * @Date 2021/1/18 11:11
 * @Description TODO
 */
public class Resource {
    String resourceName;
    String[] roles;

    @Override
    public String toString() {
        return "Resource{" +
                "resourceName='" + resourceName + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }

    public Resource(String resourceName, String[] roles) {
        this.resourceName = resourceName;
        this.roles = roles;
    }

    public Resource() {
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
