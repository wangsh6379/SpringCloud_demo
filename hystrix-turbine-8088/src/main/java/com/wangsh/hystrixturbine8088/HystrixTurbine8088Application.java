package com.wangsh.hystrixturbine8088;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//开通多组件监控组件Turbine
@EnableTurbine
public class HystrixTurbine8088Application {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbine8088Application.class, args);
	}

}
