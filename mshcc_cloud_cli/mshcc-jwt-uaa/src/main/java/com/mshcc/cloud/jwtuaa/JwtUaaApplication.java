package com.mshcc.cloud.jwtuaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mshcc
 * @Date 2021/1/5 11:02
 * @Description TODO 令牌存储策略
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.mshcc.cloud.jwtuaa.mapper")
public class JwtUaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtUaaApplication.class, args);
	}

}
