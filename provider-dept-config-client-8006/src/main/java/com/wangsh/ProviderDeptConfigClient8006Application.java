package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 集成springcloud config client从git获取配置文件生成服务提供者 8006
 */
@SpringBootApplication
//集成Eureka服务注册
@EnableEurekaClient
//开启服务发现
@EnableDiscoveryClient
public class ProviderDeptConfigClient8006Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDeptConfigClient8006Application.class, args);
	}

}
