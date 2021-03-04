package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 集成config调用git上的配置文件来创建Eureka
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigClient8762Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigClient8762Application.class, args);
	}

}
