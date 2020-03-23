package com.weiyi.springcloud.controller;

import com.weiyi.springcloud.service.PaymentService;
import entity.CommonResult;
import entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/index")
    public String index() {
        return "hello springBoot";
    }


    @RequestMapping("/get")
    public CommonResult<Payment> getPayment(Long paymentId) {

        CommonResult<Payment> commonResult = new CommonResult<>();

        Payment payment = paymentService.queryPament(paymentId);

        commonResult.setData(payment);
        System.out.println("当前服务：" + serverPort);
        return commonResult;
    }

    @RequestMapping("/add")
    public CommonResult<Boolean> getPayment(@RequestBody Payment payment) {

        CommonResult<Boolean> commonResult = new CommonResult<>();

        paymentService.addPayment(payment);

        commonResult.setData(true);
        System.out.println("当前服务：" + serverPort);
        return commonResult;
    }

    @RequestMapping("/delete")
    public CommonResult<Boolean> deletePayment(Long paymentId) {

        CommonResult<Boolean> commonResult = new CommonResult<>();

        paymentService.deletePayment(paymentId);

        commonResult.setData(true);
        System.out.println("当前服务：" + serverPort);
        return commonResult;
    }

    @RequestMapping("/update")
    public CommonResult<Boolean> updatePayment(@RequestBody Payment payment) {

        CommonResult<Boolean> commonResult = new CommonResult<>();

        paymentService.updatePayment(payment);

        commonResult.setData(true);
        System.out.println("当前服务：" + serverPort);
        return commonResult;
    }

    @RequestMapping("/load")
    public String getBalancer() {
        return "8002";
    }
}
