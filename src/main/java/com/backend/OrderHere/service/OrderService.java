package com.backend.OrderHere.service;

import com.backend.OrderHere.dto.OrderDishDTO;
import com.backend.OrderHere.dto.PlaceOrderDTO;
import com.backend.OrderHere.mapper.OrderMapper;
import com.backend.OrderHere.model.Dish;
import com.backend.OrderHere.model.LinkOrderDish;
import com.backend.OrderHere.model.Order;
import com.backend.OrderHere.repository.DishRepository;
import com.backend.OrderHere.repository.LinkOrderDishRepository;
import com.backend.OrderHere.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final LinkOrderDishRepository linkOrderDishRepository;
    private final DishRepository dishRepository;
    private final OrderMapper orderMapper;
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
