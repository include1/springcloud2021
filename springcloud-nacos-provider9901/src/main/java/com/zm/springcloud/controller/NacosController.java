package com.zm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/{id}")
    public String nacosTest(@PathVariable(name = "id") String id) {
        return "use nacos as reigstry -- --当前服务端口号：" + serverPort + "输入参数：" + id;
    }
}
