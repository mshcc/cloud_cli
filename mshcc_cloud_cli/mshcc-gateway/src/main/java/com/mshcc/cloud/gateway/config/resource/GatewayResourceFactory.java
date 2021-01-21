package com.mshcc.cloud.gateway.config.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mshcc
 * @Date 2021/1/18 10:58
 * @Description TODO 配置资源需要什么权限
 */
@Component
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class GatewayResourceFactory {
    Resource[] resources;

    public GatewayResourceFactory(Resource[] resources) {
        this.resources = resources;
    }

    public GatewayResourceFactory() {
    }

    @Override
    public String toString() {
        return "GatewayResourceFactory{" +
                "resources=" + Arrays.toString(resources) +
                '}';
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }
}

