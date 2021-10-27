package com.zm.springcloud.service.impl;

import com.zm.springcloud.entities.Order;
import com.zm.springcloud.mapper.OrderMapper;
import com.zm.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }

    @Override
    public int query(Integer userId, Integer productId) {
        return orderMapper.query(userId, productId);
    }

    @Override
    public int update(Integer userId, Integer productId, Integer status) {
        return orderMapper.update(userId, productId, status);
    }

    @Override
    public List<Order> queryAll() {
        return orderMapper.queryAll();
    }
}
