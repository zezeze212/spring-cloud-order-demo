package com.zezeze.order.service.service.impl;

import com.zezeze.order.api.dto.CreateOrderRequest;
import com.zezeze.order.api.enums.OrderStatusEnum;
import com.zezeze.order.api.vo.OrderVO;
import com.zezeze.order.service.entity.OrderEntity;
import com.zezeze.order.service.mapper.OrderMapper;
import com.zezeze.order.service.service.OrderService;
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
        BigDecimal productPrice = new BigDecimal("99.00");

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo("ORDER" + System.currentTimeMillis());
        orderEntity.setUserId(request.getUserId());
        orderEntity.setProductId(request.getProductId());
        orderEntity.setProductName("测试商品");
        orderEntity.setProductPrice(productPrice);
        orderEntity.setQuantity(request.getQuantity());
        orderEntity.setTotalAmount(productPrice.multiply(new BigDecimal(request.getQuantity())));
        orderEntity.setStatus(OrderStatusEnum.CREATED.getCode());
        orderEntity.setCreateTime(LocalDateTime.now());
        orderEntity.setUpdateTime(LocalDateTime.now());

        orderMapper.insertOrder(orderEntity);

        return convertToVO(orderEntity);
    }

    @Override
    public OrderVO getOrderById(Long id) {
        OrderEntity orderEntity = orderMapper.selectOrderById(id);

        if (orderEntity == null) {
            return null;
        }

        return convertToVO(orderEntity);
    }

    private OrderVO convertToVO(OrderEntity orderEntity) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(orderEntity.getId());
        orderVO.setOrderNo(orderEntity.getOrderNo());
        orderVO.setUserId(orderEntity.getUserId());
        orderVO.setProductId(orderEntity.getProductId());
        orderVO.setProductName(orderEntity.getProductName());
        orderVO.setProductPrice(orderEntity.getProductPrice());
        orderVO.setQuantity(orderEntity.getQuantity());
        orderVO.setTotalAmount(orderEntity.getTotalAmount());
        orderVO.setStatus(orderEntity.getStatus());
        orderVO.setCreateTime(orderEntity.getCreateTime());

        return orderVO;
    }
}