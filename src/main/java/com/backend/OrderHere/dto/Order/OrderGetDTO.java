package com.backend.OrderHere.dto.Order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderGetDTO {
    private Integer orderId;
    private Integer userId;
    private String userName;
    private String orderStatus;
    private String orderType;
    private Integer tableNumber;
    private String pickupTime;
    private String address;
    private BigDecimal totalPrice;
    private String note;
}
