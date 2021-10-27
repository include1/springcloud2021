package com.zm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyRuleImpl implements MyRule {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstanceList) {
        //取出对应的实例
        int index = getIndexAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

    //计算请求次数
    public final int getIndexAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次请求访问次数" + next);
        return next;
    }
}
