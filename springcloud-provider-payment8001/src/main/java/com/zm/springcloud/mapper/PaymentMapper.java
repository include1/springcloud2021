package com.zm.springcloud.mapper;

import com.zm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    //写操作
    public int create(Payment payment);
    //查询操作
    public Payment getPaymentById(@Param("id") Long id);

}
