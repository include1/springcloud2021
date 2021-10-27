package com.zm.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_Gloal_FallbackMethod")
public class OrderController {


    @Resource
    private PaymentService paymentService;

    @GetMapping("/consume/payment/hystrix/ok/{id}")
//    @HystrixCommand(fallbackMethod = "fallback_payment_ok",
//            commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String payment_ok(@PathVariable("id") Integer id) {
        return paymentService.payment_ok(id);
    }

    @GetMapping("/consume/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id) {
        return paymentService.payment_timeout(id);
    }


    private String fallback_payment_ok(Integer id) {
        return "服务器中忙...稍后再试";
    }

    //加一个全局降级服务方法
    public String payment_Gloal_FallbackMethod(){
        return "Global异常处理消息，请稍后再试，O(∩_∩)";
    }
}
