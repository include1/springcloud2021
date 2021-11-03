package com.zm.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumeController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/nacos/consume/{id}")
    public String test(@PathVariable(name = "id") String id) {
        ServiceInstance instance = loadBalancerClient.choose("springcloud-nacos-provider");
        String path = String.format("http://%s:%s/nacos/" + id, instance.getHost(), instance.getPort(), id);
        String str = restTemplate.getForObject(path, String.class);
        return str;
    }
}
