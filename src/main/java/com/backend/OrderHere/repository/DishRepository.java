package com.backend.OrderHere.repository;

import com.backend.OrderHere.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    Page<Dish> findDishesByRestaurantId(Integer restaurantId, Pageable pageable);
}
