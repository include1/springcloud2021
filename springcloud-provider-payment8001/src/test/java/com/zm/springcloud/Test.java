package com.zm.springcloud;

import com.zm.springcloud.entities.Payment;
import com.zm.springcloud.service.PaymentService;
import net.bytebuddy.asm.Advice;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private PaymentService paymentService;

    //测试paymentService中的getPaymentById方法
    @org.junit.Test
    public void testGetPaymentById(){
        Payment paymentById = paymentService.getPaymentById(1L);
        System.out.println(paymentById);
    }
}
