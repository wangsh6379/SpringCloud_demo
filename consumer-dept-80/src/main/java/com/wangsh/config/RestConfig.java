package com.wangsh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    /**
     * 注入RestTemplate到容器中
     * @return
     */
    @Bean
    //注意：如果使用微服务名称调用微服务，则必须加上@LoadBalanced，进行发现服务
    //默认使用轮训的规则进行服务之间调用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
