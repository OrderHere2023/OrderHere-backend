package com.backend.OrderHere.dto.Ingredient;

import lombok.Data;

@Data
public class DeleteIngredientDTO {
    private Integer dishID;
    private Integer ingredientID;
}
