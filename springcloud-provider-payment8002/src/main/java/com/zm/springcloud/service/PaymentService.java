package com.zm.springcloud.service;

import com.zm.springcloud.entities.Payment;

public interface PaymentService {

    //添加
    public int create(Payment payment);
    //查询
    public Payment getPaymentById(Long id);
}
