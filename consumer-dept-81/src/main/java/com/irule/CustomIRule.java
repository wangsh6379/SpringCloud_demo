package com.irule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomIRule {
    @Bean
    public IRule custIRule(){
        return new MyIRule();
    }
}
