package com.weiyi.springcloud.service;

import entity.Payment;

public interface PaymentService {

    /**
     * 新增
     *
     * @param payment 支付订单
     */
    void addPayment(Payment payment);

    /**
     * 删除
     *
     * @param paymentId 主键ID
     */
    void deletePayment(Long paymentId);

    /**
     * 更新
     *
     * @param payment 支付订单
     */
    void updatePayment(Payment payment);

    /**
     * 查询
     *
     * @return 订单对象
     */
    Payment queryPament(Long paymentId);

}
