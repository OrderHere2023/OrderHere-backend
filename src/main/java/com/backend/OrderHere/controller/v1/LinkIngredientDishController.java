package com.backend.OrderHere.controller.v1;

import com.backend.OrderHere.dto.Ingredient.AddIngredientDTO;
import com.backend.OrderHere.dto.Ingredient.DeleteIngredientDTO;
import com.backend.OrderHere.dto.Ingredient.GetIngredientDTO;
import com.backend.OrderHere.model.LinkIngredientDish;
import com.backend.OrderHere.service.LinkIngredientDishService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/public/link-ingredient-dish")
public class LinkIngredientDishController {
    @Autowired
    private LinkIngredientDishService linkIngredientDishService;

    @PostMapping
    public LinkIngredientDish createLink(@RequestBody AddIngredientDTO addIngredientDTO) {
        return linkIngredientDishService.createLink(addIngredientDTO);
    }

    @GetMapping("dish/{dishID}")
    public ResponseEntity<List<GetIngredientDTO>> findByDishID(@PathVariable Integer dishID) {
        List<GetIngredientDTO> dtoList = linkIngredientDishService.findGetIngredientDTOByDishID(dishID);
        return ResponseEntity.ok(dtoList);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLink(@RequestBody DeleteIngredientDTO deleteIngredientDTO) {
        try {
            linkIngredientDishService.deleteById(deleteIngredientDTO);
            return ResponseEntity.ok("Link deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
