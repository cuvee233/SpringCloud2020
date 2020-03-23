package com.weiyi.springcloud.service.impl;

import com.weiyi.springcloud.mapper.PaymentMapper;
import com.weiyi.springcloud.service.PaymentService;
import entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public void addPayment(Payment payment) {
        log.info("addPayment start payment = {}", payment);

        paymentMapper.insert(payment);

        log.info("addPayment finished payment = {}", payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        log.info("deletePayment start paymentId = {}", paymentId);

        Example example = new Example(Payment.class);
        example.createCriteria().andEqualTo("id", paymentId);
        paymentMapper.deleteByExample(example);

        log.info("deletePayment finished paymentId = {}", paymentId);

    }

    @Override
    public void updatePayment(Payment payment) {
        log.info("updatePayment start payment = {}", payment);

        paymentMapper.updateByPrimaryKey(payment);

        log.info("updatePayment finished payment = {}", payment);
    }

    @Override
    public Payment queryPament(Long paymentId) {
        log.info("queryPamentList start paymentId = {}", paymentId);

        Payment payment = new Payment();
        payment.setId(paymentId);
        payment = paymentMapper.selectOne(payment);

        log.info("queryPamentList finished  payment = {}", payment);

        return payment;
    }
}
