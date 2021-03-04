package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul网关。
 * 可以直接通过Zuul + 微服务名称来访问微服务
 */
@SpringBootApplication
//开启网关服务功能
@EnableZuulProxy
public class Zull9001Application {

	public static void main(String[] args) {
		SpringApplication.run(Zull9001Application.class, args);
	}

}
