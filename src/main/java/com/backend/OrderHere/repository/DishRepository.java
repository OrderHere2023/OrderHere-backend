package com.backend.OrderHere.repository;

import com.backend.OrderHere.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {
}
