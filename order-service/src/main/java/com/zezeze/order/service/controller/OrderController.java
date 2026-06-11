package com.zezeze.order.service.controller;

import com.zezeze.common.result.Result;
import com.zezeze.order.api.dto.CreateOrderRequest;
import com.zezeze.order.api.enums.OrderStatusEnum;
import com.zezeze.order.api.vo.OrderVO;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public Result<OrderVO> createOrder(@RequestBody CreateOrderRequest request) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(1L);
        orderVO.setOrderNo("ORDER202606110001");
        orderVO.setUserId(request.getUserId());
        orderVO.setProductId(request.getProductId());
        orderVO.setProductName("测试商品");
        orderVO.setProductPrice(new BigDecimal("99.00"));
        orderVO.setQuantity(request.getQuantity());
        orderVO.setTotalAmount(new BigDecimal("99.00").multiply(new BigDecimal(request.getQuantity())));
        orderVO.setStatus(OrderStatusEnum.CREATED.getCode());
        orderVO.setCreateTime(LocalDateTime.now());

        return Result.success(orderVO);
    }

    @GetMapping("/{id}")
    public Result<OrderVO> getOrderById(@PathVariable("id") Long id) {
        OrderVO orderVO = new OrderVO();
        orderVO.setId(id);
        orderVO.setOrderNo("ORDER202606110001");
        orderVO.setUserId(1001L);
        orderVO.setProductId(2001L);
        orderVO.setProductName("测试商品");
        orderVO.setProductPrice(new BigDecimal("99.00"));
        orderVO.setQuantity(2);
        orderVO.setTotalAmount(new BigDecimal("198.00"));
        orderVO.setStatus(OrderStatusEnum.CREATED.getCode());
        orderVO.setCreateTime(LocalDateTime.now());

        return Result.success(orderVO);
    }
}