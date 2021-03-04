package com.wangsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// 开启config服务
@EnableConfigServer
public class Config9011Application {

	public static void main(String[] args) {
		SpringApplication.run(Config9011Application.class, args);
	}

}
