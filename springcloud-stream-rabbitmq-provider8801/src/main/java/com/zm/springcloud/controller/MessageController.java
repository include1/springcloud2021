package com.zm.springcloud.controller;

import com.zm.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return iMessageProvider.send();
    }
}
