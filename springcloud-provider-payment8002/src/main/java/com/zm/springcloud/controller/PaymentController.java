package com.zm.springcloud.controller;

import com.zm.springcloud.entities.CommonResult;
import com.zm.springcloud.entities.Payment;
import com.zm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
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
            return new CommonResult<Payment>(200, "查询成功------来自8002端口", paymentById);
        } else {
            return new CommonResult<Payment>(500, "查询失败------来自8002端口", null);
        }
    }
}
