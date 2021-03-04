package com.wangsh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
//chain的中文含义是链式的，设置为true，则setter方法返回当前对象
//fluent的中文含义是流畅的，设置为true，则getter和setter方法的方法名都变成基础属性名，且setter方法返回当前对象
@Accessors(chain = true)
public class Dept implements Serializable{
    private Integer deptno;
    private String dname;
    private String db_source;
}
