package com.zm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9901 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9901.class, args);
    }
}
