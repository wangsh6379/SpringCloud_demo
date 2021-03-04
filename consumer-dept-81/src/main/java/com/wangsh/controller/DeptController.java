package com.wangsh.controller;

import com.wangsh.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用RestTemplate调用服务提供者服务
 * @author wangsh
 * @date 2021年3月2日 13:57:01
 */
@RestController
public class DeptController {

    //服务提供者地址
    private String url = "http://127.0.0.1:8001";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Integer id) {

        return restTemplate.getForObject(url+"/dept/get/"+id, Dept.class);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        List<Dept> list = restTemplate.getForObject(url+"/dept/list", List.class);
        return list;
    }
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
       return restTemplate.postForObject(url+"/dept/add",dept,Boolean.class);
    }
}
