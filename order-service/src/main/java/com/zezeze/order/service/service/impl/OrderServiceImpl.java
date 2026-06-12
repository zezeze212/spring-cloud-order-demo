package com.zezeze.order.service.service.impl;

import com.zezeze.order.api.dto.CreateOrderRequest;
import com.zezeze.order.api.vo.OrderVO;
import com.zezeze.order.service.service.OrderService;
import com.zezeze.order.service.mapper.OrderMapper;
import com.zezeze.order.api.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderVO createOrder(CreateOrderRequest request) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(1L); // 可以用雪花或者自增策略
        orderVO.setOrderNo("ORDER" + System.currentTimeMillis());
        orderVO.setUserId(request.getUserId());
        orderVO.setProductId(request.getProductId());
        orderVO.setProductName("测试商品");
        orderVO.setProductPrice(new BigDecimal("99.00"));
        orderVO.setQuantity(request.getQuantity());
        orderVO.setTotalAmount(orderVO.getProductPrice().multiply(new BigDecimal(request.getQuantity())));
        orderVO.setStatus(OrderStatusEnum.CREATED.getCode());
        orderVO.setCreateTime(LocalDateTime.now());

        orderMapper.insertOrder(orderVO);
        return orderVO;
    }

    @Override
    public OrderVO getOrderById(Long id) {
        return orderMapper.selectOrderById(id);
    }
}