package com.zezeze.order.service.controller;

import com.zezeze.common.result.Result;
import com.zezeze.order.api.dto.CreateOrderRequest;
import com.zezeze.order.api.vo.OrderVO;
import com.zezeze.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @Autowired
//    private OrderService orderService;

    @PostMapping
    public Result<OrderVO> createOrder(@RequestBody CreateOrderRequest request) {
        OrderVO orderVO = orderService.createOrder(request);
        return Result.success(orderVO);
    }

    @GetMapping("/{id}")
    public Result<OrderVO> getOrderById(@PathVariable("id") Long id) {
        OrderVO orderVO = orderService.getOrderById(id);
        return Result.success(orderVO);
    }
}