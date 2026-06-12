package com.zezeze.order.service.service;

import com.zezeze.order.api.dto.CreateOrderRequest;
import com.zezeze.order.api.vo.OrderVO;

public interface OrderService {

    /**
     * 创建订单
     */
    OrderVO createOrder(CreateOrderRequest request);

    /**
     * 根据订单ID查询订单
     */
    OrderVO getOrderById(Long id);
}