package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费者，只集成Eureka来调用Eureka上注册的服务
 * 2021年3月2日 15:05:07
 */
@SpringBootApplication
//开启Eureka微服务发现功能
@EnableEurekaClient
public class ConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80Application.class, args);
    }

}
