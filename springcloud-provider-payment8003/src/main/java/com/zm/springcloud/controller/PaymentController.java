package com.zm.springcloud.controller;

import com.zm.springcloud.entities.CommonResult;
import com.zm.springcloud.entities.Payment;
import com.zm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @Autowired
    private PaymentService paymentService;


    @GetMapping(value = "/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeepr as 注册中心" + serverPort + UUID.randomUUID().toString();
    }


    @PostMapping(value = "/create")
    public CommonResult<Payment> create(Payment payment) {
        int count = paymentService.create(payment);
        if (count > 0) {
            return new CommonResult<Payment>(200, "插入成功", payment);
        } else {
            return new CommonResult<Payment>(500, "插入失败", null);
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            return new CommonResult<Payment>(200, "查询成功------来自8003端口", paymentById);
        } else {
            return new CommonResult<Payment>(500, "查询失败------来自8003端口", null);
        }
    }
}
