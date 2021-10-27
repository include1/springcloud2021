package com.zm.springcloud.controller;

import com.zm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        return paymentService.payment_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) {
        return paymentService.payment_timeout(id);
    }

    @GetMapping("/payment/hystrix/test/{id}")
    public String payment_circleBreaker_test(@PathVariable("id") Integer id) {
        return paymentService.payment_circleBreaker_test(id);
    }
}
