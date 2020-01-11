package com.example.postineurekaserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan(basePackages = {"com.example.postineurekaserver.mapper.*"})
@ComponentScan(basePackages = {"com.example.postineurekaserver.*"})
public class PostInEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostInEurekaServerApplication.class, args);
    }

}
