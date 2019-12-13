package com.example.postineurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
public class PostInEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostInEurekaServerApplication.class, args);
    }

}
