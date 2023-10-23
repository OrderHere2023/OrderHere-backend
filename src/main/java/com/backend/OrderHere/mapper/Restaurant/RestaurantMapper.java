package com.backend.OrderHere.mapper.Restaurant;

import com.backend.OrderHere.dto.Restaurant.RestaurantCreateDTO;
import com.backend.OrderHere.dto.Restaurant.RestaurantGetDTO;
import com.backend.OrderHere.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantGetDTO fromRestaurantToRestaurantGetDTO(Restaurant restaurant);

    Restaurant fromRestaurantCreateDTOToRestaurant(RestaurantCreateDTO restaurantCreateDTO);

}
