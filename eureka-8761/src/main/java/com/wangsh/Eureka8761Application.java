package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务注册
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka8761Application {

	public static void main(String[] args) {
		SpringApplication.run(Eureka8761Application.class, args);
	}

}
