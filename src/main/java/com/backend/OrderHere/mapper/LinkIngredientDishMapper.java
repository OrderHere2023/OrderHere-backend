package com.backend.OrderHere.mapper;

import com.backend.OrderHere.dto.Ingredient.GetIngredientDTO;
import com.backend.OrderHere.model.LinkIngredientDish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LinkIngredientDishMapper {
    @Mapping(target = "dishId", source = "dish.dishId")
    @Mapping(target = "ingredientId", source = "ingredient.ingredientId")
    GetIngredientDTO toDto(LinkIngredientDish linkIngredientDish);

}
