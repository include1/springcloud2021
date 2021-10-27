package com.zm.springcloud.mapper;

import com.zm.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    //查询全部数据
    public List<Order> queryAll();

    //订单增加
    public int add(Order order);

    //查看订单状态
    public int query(@Param("userId") Integer userId, @Param("productId") Integer productId);

    //修改订单状态
    public int update(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("status") Integer status);
}
