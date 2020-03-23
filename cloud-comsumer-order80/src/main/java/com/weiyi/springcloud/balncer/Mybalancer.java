package com.weiyi.springcloud.balncer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡算法，轮询
 */
@Component
public class Mybalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instanceList) {

        int size = instanceList.size();
        int index = getIndexAndSet() % size;
        ServiceInstance serviceInstance = instanceList.get(index);
        System.out.println("当前请求次数：" + atomicInteger.get());

        return serviceInstance;
    }

    private int getIndexAndSet() {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

}
