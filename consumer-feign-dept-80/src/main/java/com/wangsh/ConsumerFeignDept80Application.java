package com.wangsh;

import com.irule.CustomIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 集成Feign后，将无需关心微服务名称与端口号，在API模块进行接口调用微服务。将http的请求，转变成传统我们，面向接口开发
 */
@SpringBootApplication
//注意，在Feign中需要有Eureka支撑才可以调用微服务
@EnableEurekaClient
//这里使用Feign的形式通过接口调用微服务，必须要有扫描的包
@EnableFeignClients(basePackages= {"com.wangsh"})
@ComponentScan("com.wangsh")
@RibbonClient(name="PROVIDER-DEPT",configuration=CustomIRule.class)
public class ConsumerFeignDept80Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignDept80Application.class, args);
	}

}
