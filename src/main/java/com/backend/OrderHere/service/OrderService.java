package com.backend.OrderHere.service;
import com.backend.OrderHere.dto.OrderDishDTO;
import com.backend.OrderHere.dto.PlaceOrderDTO;
import com.backend.OrderHere.model.Dish;
import com.backend.OrderHere.model.LinkOrderDish;
import com.backend.OrderHere.repository.DishRepository;
import com.backend.OrderHere.repository.LinkOrderDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.backend.OrderHere.dto.Order.OrderGetDTO;
import com.backend.OrderHere.dto.Order.UpdateOrderStatusDTO;
import com.backend.OrderHere.exception.ResourceNotFoundException;
import com.backend.OrderHere.mapper.Order.OrderMapper;
import com.backend.OrderHere.mapper.Order.UpdateOrderStatusMapper;
import com.backend.OrderHere.model.Order;
import com.backend.OrderHere.model.enums.OrderStatus;
import com.backend.OrderHere.model.enums.OrderType;
import com.backend.OrderHere.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final UpdateOrderStatusMapper UpdateOrderStatusMapper;

    public List<OrderGetDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::fromOrderToOrderGetDTO).collect(Collectors.toList());
    }

    public OrderGetDTO getOrderById(Integer orderId) {
        return orderMapper.fromOrderToOrderGetDTO(orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found")));
    }

    public List<OrderGetDTO> getOrderByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus).stream().map(orderMapper::fromOrderToOrderGetDTO).collect(Collectors.toList());
    }

    public List<OrderGetDTO> getOrderByOrderType(OrderType orderType) {
        return orderRepository.findByOrderType(orderType).stream().map(orderMapper::fromOrderToOrderGetDTO).collect(Collectors.toList());
    }

    public UpdateOrderStatusDTO updateOrderStatus(UpdateOrderStatusDTO updateOrderStatusDTO) {

        Order order = orderRepository.findById(updateOrderStatusDTO.getOrderId()).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setOrderStatus(updateOrderStatusDTO.getOrderStatus());
        orderRepository.save(order);
        return UpdateOrderStatusMapper.fromOrdertoUpdateOrderStatusDTO(order);
    }
   @Autowired
    public OrderService(OrderRepository orderRepository,OrderMapper orderMapper,LinkOrderDishRepository linkOrderRepository,DishRepository dishRepository){
        this.orderRepository=orderRepository;
        this.orderMapper=orderMapper;
        this.linkOrderDishRepository=linkOrderRepository;
        this.dishRepository=dishRepository;
    }
    public Order PlaceOrder(PlaceOrderDTO placeOrderDTO){
        Order order=orderMapper.dtoToOrder(placeOrderDTO);
        order=orderRepository.save(order);
        List<LinkOrderDish> links= new ArrayList<LinkOrderDish>();
        for(OrderDishDTO orderDishDTO : placeOrderDTO.getDishes()){
            LinkOrderDish link=new LinkOrderDish();
            link.setOrder(order);
            Dish dish=dishRepository.findById(orderDishDTO.getDishId()).orElseThrow(() -> new RuntimeException("Dish not found with ID"+orderDishDTO.getDishId()));
            link.setDish(dish);
            link.setDishQuantity(orderDishDTO.getDishQuantity());
            links.add(link);
        }
        linkOrderDishRepository.saveAll(links);
        return order;
    }

}
