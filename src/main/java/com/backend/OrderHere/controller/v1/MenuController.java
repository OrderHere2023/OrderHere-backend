package com.backend.OrderHere.controller.v1;

import com.backend.OrderHere.dto.PagingDto;
import com.backend.OrderHere.dto.dish.DishGetDto;
import com.backend.OrderHere.service.DishService;
import com.backend.OrderHere.service.enums.DishSort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.backend.OrderHere.util.SortHelper.getSortOrder;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Validated
public class MenuController {
    private final DishService dishService;

    @GetMapping("/dishes")
    @ResponseStatus(HttpStatus.OK)
    public PagingDto<List<DishGetDto>> getDishes(@PathVariable Integer restaurantId,
                                                 @RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "category") String sort,
                                                 @RequestParam(defaultValue = "asc") String order) {
        return dishService.getDishPageByRestaurantId(
                restaurantId,
                page,
                size,
                DishSort.getEnumByString(sort),
                getSortOrder(order)
        );
    }
}
