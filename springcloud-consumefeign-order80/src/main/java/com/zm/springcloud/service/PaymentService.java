package com.zm.springcloud.service;

import com.zm.springcloud.entities.CommonResult;
import com.zm.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment);
}
