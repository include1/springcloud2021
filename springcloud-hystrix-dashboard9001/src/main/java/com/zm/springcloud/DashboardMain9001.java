package com.zm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DashboardMain9001.class, args);
    }
}
