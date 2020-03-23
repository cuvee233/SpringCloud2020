package com.weiyi.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    // URL访问
    // private static final String PAYMENT_URL = "http://localhost:8001";

    // 服务名访问
    private static final String PAYMENT_URL = "http://cloud-provider-payment";


    @RequestMapping(value = "/get")
    public String paymentzk() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }

}
