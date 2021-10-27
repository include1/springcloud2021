package com.zm.springcloud.service;


import com.zm.springcloud.entities.Order;

import java.util.List;

public interface OrderService {

    public int add(Order order);

    public int query(Integer userId, Integer productId);

    public int update(Integer userId, Integer productId, Integer status);

    public List<Order> queryAll();
}
