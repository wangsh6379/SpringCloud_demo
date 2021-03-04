package com.wangsh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangsh.entity.Dept;
import com.wangsh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Hystrix 熔断、降级处理
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    //Hystrix，当该方法抛出异常的情况下去调用lstError进行提示
    @HystrixCommand(fallbackMethod = "getError")
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    //Eureka做服务发现
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/dept/eureka")
    public String eureka_dis() {
        List<String> services = client.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = client.getInstances(service);
            for(ServiceInstance serviceInstance :instances){
                System.out.println(serviceInstance.getUri() + "====================" + service);
            }
        }
        return null;
    }

    /**
     * 使用Hystrix的熔断机制，当接口存在问题的时候会调用另一个方法去处理出现的问题。
     * 处理的方法也可以获取链接上的参数.
     *
     * 利用Hystrix的降级进行处理。
     * 问题：这种写法存在强耦合，如果一个接口需要一个error方法去接收，那么会跟随接口数量来递增。难以维护。
     * 解决：在消费者端在调用服务的时候进行处理，处理如果获取服务存在问题，就应该在客户端进行降级处理，不调用该接口。或者对出现问题的服务进行友好提示。
     * 这样可以解决业务代码与问题提示之间的耦合问题
     * @param id
     * @return
     */
    public Dept getError(@PathVariable("id") Integer id){
        return  new Dept().setDeptno(id).setDname("您请求的数据没有对应信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
    }
}
