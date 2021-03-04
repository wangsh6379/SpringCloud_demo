package com.wangsh.service;

import com.wangsh.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//使用Feign：指定微服务名称，使用Feign通过接口的形式去获得微服务的服务
//fallbackFactory：使用Hystrix的降级机制，如果存在接口异常则调用fallback进行处理
@FeignClient(value = "PROVIDER-DEPT",fallbackFactory = DeptFeignServiceFallbackFactory.class)
public interface DeptFeignService {

    @PostMapping("/dept/add")
    public boolean add(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id);

    @GetMapping("/dept/list")
    public List<Dept> list();
}
