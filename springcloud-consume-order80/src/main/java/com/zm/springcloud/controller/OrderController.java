package com.zm.springcloud.controller;

import com.zm.springcloud.entities.CommonResult;
import com.zm.springcloud.entities.Order;
import com.zm.springcloud.entities.Payment;
import com.zm.springcloud.lb.MyRuleImpl;
import com.zm.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private String url = "http://springcloud-payment-service";

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyRuleImpl mRuleImpl;

    @PostMapping(value = "/add")
    public CommonResult<Order> add(@RequestBody Order order) {
        int add = orderService.add(order);
        if (add > 0) {
            return new CommonResult<>(200, "插入成功", order);
        } else {
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @GetMapping("/query")
    public CommonResult<String> query(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        int query = orderService.query(userId, productId);
        String message = "";
        if (query == 1) {
            message = "已完结";
        } else {
            message = "创建中";
        }
        return new CommonResult<>(200, "查询结果：", "状态为：" + query + message);
    }

    @GetMapping("/update")
    public CommonResult update(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        int update = orderService.update(userId, productId, 1);
        if (update > 0) {
            return new CommonResult<>(200, "更新成功", null);
        } else {
            return new CommonResult<>(444, "更新失败", null);
        }
    }

    @GetMapping("/queryAll")
    public CommonResult<List<Order>> queryAll() {
        List<Order> orderList = orderService.queryAll();
        if (orderList.size() == 0) {
            return new CommonResult<>(200, "暂无记录", null);
        } else {
            return new CommonResult<>(200, "查询结果：", orderList);
        }

    }


    @GetMapping("/test/{id}")
    public CommonResult<Payment> test(@PathVariable("id") Long id) {
        List<ServiceInstance> instancesById = discoveryClient.getInstances("springcloud-payment-service");
        if (instancesById == null || instancesById.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = mRuleImpl.getServiceInstance(instancesById);
        URI uri = serviceInstance.getUri();
        System.out.println(uri+"打印服务地址");
        CommonResult commonResult = restTemplate.getForObject(uri + "/payment/getPaymentById/" + id, CommonResult.class);
        return commonResult;
    }
}