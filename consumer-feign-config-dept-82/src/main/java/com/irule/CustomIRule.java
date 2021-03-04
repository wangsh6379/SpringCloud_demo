package com.irule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里使用Feign的形式模拟Ribbon的方式进行自定义负载均衡测试。
 * 可以自定义，模拟进行测试
 */
@Configuration
public class CustomIRule {
    @Bean
    public IRule custIRule(){
        return new MyIRule();
    }
}
