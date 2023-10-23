package com.backend.OrderHere.service;

import com.backend.OrderHere.dto.Restaurant.RestaurantCreateDTO;
import com.backend.OrderHere.mapper.Restaurant.RestaurantMapper;
import com.backend.OrderHere.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    public final RestaurantRepository restaurantRepository;

    public final RestaurantMapper restaurantMapper;

    public RestaurantCreateDTO createRestaurant(RestaurantCreateDTO restaurantCreateDTO) {
        return null;
    }

}
