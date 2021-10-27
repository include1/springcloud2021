package com.zm.springcloud.controller;

import com.zm.springcloud.entities.CommonResult;
import com.zm.springcloud.entities.Payment;
import com.zm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consume/feign/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping(value = "/consume/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }
}
