package com.zm.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String payment_ok(Integer id) {
        return "PaymentFallbackService ----------- payment_ok";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "PaymentFallbackService ------ payment_timeout";
    }
}
