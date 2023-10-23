package com.backend.OrderHere.controller.v1;

import com.backend.OrderHere.dto.PlaceOrderDTO;
import com.backend.OrderHere.model.Order;
import com.backend.OrderHere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {
    private final OrderService orderService;
    @Autowired
    public  OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO){
        Order placeOrder=orderService.PlaceOrder(placeOrderDTO);
        return new ResponseEntity<>(placeOrder, HttpStatus.CREATED);
    }
}
