package com.zm.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String payment_ok(Integer id) {

        return Thread.currentThread().getName() + "port: " + serverPort + "payment_ok: " + id + "O(∩_∩)O哈哈~";
    }

    public String payment_timeout(Integer id) {
        Long time = 3l;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "port: " + serverPort + "payment_timeout: " + id + "O(∩_∩)O哈哈~";

    }

    //hystrix的三个重要参数：休眠时间窗、请求总数、请求错误百分比
    @HystrixCommand(fallbackMethod = "paymentFallback_circleBreaker_test",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String payment_circleBreaker_test(Integer id) {

        if (id < 0) {
            throw new RuntimeException("传参不能为负值 o(╥﹏╥)o");
        }
        //使用糊涂工具
        String s = IdUtil.simpleUUID();
        return "payment_circleBreaker_test ------访问成功 " + s;
    }
    //写一个兜底方法fallback
    public String paymentFallback_circleBreaker_test(Integer id){
        return "paymentFallback_circleBreaker_test----进行服务降级，开启熔断-----传入的参数为：" + id;
    }
}
