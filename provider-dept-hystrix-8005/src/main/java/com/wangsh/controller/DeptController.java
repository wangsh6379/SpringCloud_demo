package com.wangsh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangsh.entity.Dept;
import com.wangsh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //注意：在API模块加上降级处理后，当微服务存在异常或者无法调用的情况下会调用API的本地Fallback。如果在微服务端存在@HystrixCommand注解，则优先返回微服务提供的Fallback方法
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
     * 也可以获取链接上的参数
     * @param id
     * @return
     */
    public Dept getError(@PathVariable("id") Integer id){
        return  new Dept().setDeptno(id).setDname("您请求的数据没有对应信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
    }
}
