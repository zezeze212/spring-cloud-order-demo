package com.zezeze.order.service.mapper;

import com.zezeze.order.service.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    int insertOrder(OrderEntity orderEntity);

    OrderEntity selectOrderById(@Param("id") Long id);
}