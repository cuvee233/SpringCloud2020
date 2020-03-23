package com.weiyi.springcloud.controller;

import com.weiyi.springcloud.balncer.LoadBalancer;
import entity.CommonResult;
import entity.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    // URL访问
    // private static final String PAYMENT_URL = "http://localhost:8001";

    // 服务名访问
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @RequestMapping("/add")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add/", payment, CommonResult.class);
    }

    @RequestMapping("/get")
    public CommonResult<Payment> query(Long paymentId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get?paymentId=" + paymentId, CommonResult.class);
    }


    @RequestMapping("/load/get")
    public String getLoadBalancer() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        ServiceInstance instance = loadBalancer.getInstance(instances);

        if (instance == null) {
            return "service not found";
        }

        String result = restTemplate.getForObject(instance.getUri() + "/payment/load", String.class);
        System.out.println(result);
        return result;
    }


}
