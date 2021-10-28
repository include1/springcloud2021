package com.zm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderMain8801.class, args);
    }
}
