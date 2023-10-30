package com.backend.OrderHere.repository;

import com.backend.OrderHere.model.Dish;
import com.backend.OrderHere.model.Ingredient;
import com.backend.OrderHere.model.LinkIngredientDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LinkIngredientDishRepository extends JpaRepository<LinkIngredientDish, Integer> {
    List<LinkIngredientDish> findByDish(Dish dish);

    Optional<Object> findByDishAndIngredient(Dish dish, Ingredient ingredient);
}
