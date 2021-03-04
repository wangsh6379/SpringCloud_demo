package com.wangsh.controller;

import com.wangsh.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用RestTemplate调用服务提供者服务
 *
 * @author wangsh
 * @date 2021年3月2日 13:57:01
 */
@RestController
public class DeptEurekaController {

    //使用微服务提供的服务提供者名称，直接使用微服务名称调用微服务
    private String url = "http://PROVIDER-DEPT2";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/eureka/get/{id}")
    public Dept get(@PathVariable Integer id) {

        return restTemplate.getForObject( url+ "/dept/get/" + id, Dept.class);
    }

    @GetMapping("/eureka/list")
    public List<Dept> list() {
        List<Dept> list = restTemplate.getForObject(url + "/dept/list", List.class);
        return list;
    }

    @PostMapping("/eureka/add")
    public boolean add(@RequestBody Dept dept) {
        return restTemplate.postForObject(url + "/dept/add", dept, Boolean.class);
    }
}
