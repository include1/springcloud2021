package com.zm.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "http://springcloud-payment-service";

    @GetMapping("/consume/zk")
    public String zk() {
        String forObject = restTemplate.getForObject(url + "/payment/zk", String.class);
        return forObject;
    }
}
