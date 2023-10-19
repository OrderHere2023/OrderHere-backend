package com.backend.OrderHere.mapper.Order;

import com.backend.OrderHere.dto.Order.OrderGetDTO;
import com.backend.OrderHere.model.Order;
import com.backend.OrderHere.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class OrderMapper {

    public OrderGetDTO fromOrderToOrderGetDTO(Order order) {

        return OrderGetDTO.builder()
                .orderId(order.getOrderId())
                .userId(Optional.ofNullable(order.getUser()).map(User::getUserId).orElse(null))
                .userName(Optional.ofNullable(order.getUser()).map(User::getUsername).orElse(null))
                .orderStatus(order.getOrderStatus().toString())
                .orderType(order.getOrderType().toString())
                .tableNumber(order.getTableNumber())
                .pickupTime(order.getPickupTime().toString())
                .address(order.getAddress())
                .totalPrice(order.getTotalPrice())
                .note(order.getNote())
                .build();

    };
}
