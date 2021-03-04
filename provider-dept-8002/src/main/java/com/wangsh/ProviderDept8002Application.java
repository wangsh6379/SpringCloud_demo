package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者 8002
 */
@SpringBootApplication
//集成Eureka服务注册
@EnableEurekaClient
//开启服务发现
@EnableDiscoveryClient
public class ProviderDept8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDept8002Application.class, args);
    }

}
