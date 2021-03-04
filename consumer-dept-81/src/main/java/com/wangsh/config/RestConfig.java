package com.wangsh.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 开启定制自定义负载均衡规则。这是Ribbon内置的7种负载均衡规则
     * @return
     */
//    @Bean
//    public IRule rule(){
//        //RetryRule  默认使用轮训的规则去调用微服务，如果其中一个微服务down机，在调用 几次后就不在调用down机的微服务
//        return new R();
//    }
}
