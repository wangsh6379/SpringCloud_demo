package com.wangsh.service;

import com.wangsh.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用Hystrix降级功能，调用接口如果存在问题则直接进行处理每一个接口对应的fallback
 * 注意：这里泛型是针对的Feign的接口。对接口内的方法进行批量Fallback
 */
@Component
public class DeptFeignServiceFallbackFactory implements FallbackFactory<DeptFeignService> {
    @Override
    public DeptFeignService create(Throwable throwable) {

        return new DeptFeignService() {

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Integer id) {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
