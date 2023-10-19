package com.backend.OrderHere.mapper;

import com.backend.OrderHere.dto.dish.DishGetDto;
import com.backend.OrderHere.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DishMapper {
    DishGetDto dishToDishGetDto(Dish dish);

}
