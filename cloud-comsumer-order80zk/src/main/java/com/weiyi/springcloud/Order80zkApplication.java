package com.weiyi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Order80zkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Order80zkApplication.class, args);
    }

}
