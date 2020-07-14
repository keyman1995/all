package com.micro.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChenGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenGatewayApplication.class, args);
    }

}
