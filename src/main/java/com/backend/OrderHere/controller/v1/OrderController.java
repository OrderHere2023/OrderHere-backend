package com.backend.OrderHere.controller.v1;
import com.backend.OrderHere.dto.PlaceOrderDTO;
import com.backend.OrderHere.model.Order;
import com.backend.OrderHere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.backend.OrderHere.dto.Order.UpdateOrderStatusDTO;
import com.backend.OrderHere.model.enums.OrderStatus;
import com.backend.OrderHere.model.enums.OrderType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
       @GetMapping
    public ResponseEntity<List<OrderGetDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderGetDTO> getOrderById(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("/status")
    public ResponseEntity<List<OrderGetDTO>> getOrderByOrderStatus(@RequestParam("orderStatus") OrderStatus orderStatus) {
            return ResponseEntity.ok(orderService.getOrderByOrderStatus(orderStatus));
    }

    @GetMapping("/type")
    public ResponseEntity<List<OrderGetDTO>> getOrderByOrderType(@RequestParam("orderType") OrderType orderType) {
        return ResponseEntity.ok(orderService.getOrderByOrderType(orderType));
    }

    @PatchMapping("/status")
    public ResponseEntity<UpdateOrderStatusDTO> updateOrderStatus(@RequestBody UpdateOrderStatusDTO updateOrderStatusDTO) {
        return ResponseEntity.ok().body(orderService.updateOrderStatus(updateOrderStatusDTO));
    }
    }

}
