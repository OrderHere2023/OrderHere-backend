package com.backend.OrderHere.controller.v1;

import com.backend.OrderHere.dto.Restaurant.RestaurantCreateDTO;
import com.backend.OrderHere.dto.Restaurant.RestaurantGetDTO;
import com.backend.OrderHere.dto.Restaurant.RestaurantUpdateDTO;
import com.backend.OrderHere.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantGetDTO>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping
    public ResponseEntity<RestaurantGetDTO> createRestaurant(@Valid @RequestBody RestaurantCreateDTO restaurantCreateDTO) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurantCreateDTO));
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantGetDTO> getRestaurantById(@PathVariable Integer restaurantId) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantGetDTO> updateRestaurantById(@PathVariable Integer restaurantId, @Valid @RequestBody RestaurantUpdateDTO restaurantUpdateDTO) {
        return ResponseEntity.ok(restaurantService.updateRestaurantById(restaurantId, restaurantUpdateDTO));
    }

}
