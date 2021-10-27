package com.zm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyRule {
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList);
}
