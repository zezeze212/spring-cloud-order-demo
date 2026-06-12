package com.zezeze.order.service.mapper;

import com.zezeze.order.api.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void insertOrder(OrderVO order);

    OrderVO selectOrderById(@Param("id") Long id);
}