package com.wangsh;

import com.irule.CustomIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 消费者
 * 2021年3月2日 15:05:07
 */
@SpringBootApplication
//开启Eureka微服务发现功能
//@EnableDiscoveryClient
@EnableEurekaClient
//注意：自定义的负载均衡配置类不能与启动类在同一个包下，必须创建一个新的包，这样扫描不到
//@RibbonClient(name = "PROVIDER-DEPT",configuration = CustomIRule.class)
@RibbonClient(name="PROVIDER-DEPT",configuration=CustomIRule.class)
public class ConsumerDept81Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept81Application.class, args);
    }

}
