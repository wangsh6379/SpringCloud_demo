package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//访问路径：http://127.0.0.1:8087/hystrix
public class Hystrix8087Application {

	public static void main(String[] args) {
		SpringApplication.run(Hystrix8087Application.class, args);
	}

}
