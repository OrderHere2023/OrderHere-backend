package com.backend.OrderHere.dto.Ingredient;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddIngredientDTO {
    private Integer dishId;
    private String name;
    private String unit;
    private BigDecimal quantityValue;
}
