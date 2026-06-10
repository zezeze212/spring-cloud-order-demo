package com.zezeze.order.api.enums;

public enum OrderStatusEnum {

    CREATED(1, "已创建"),

    PAID(2, "已支付"),

    CANCELED(3, "已取消"),

    FINISHED(4, "已完成");

    private final Integer code;

    private final String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}