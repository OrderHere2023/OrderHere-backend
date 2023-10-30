package com.backend.OrderHere.service;

import com.backend.OrderHere.dto.Ingredient.AddIngredientDTO;
import com.backend.OrderHere.dto.Ingredient.DeleteIngredientDTO;
import com.backend.OrderHere.dto.Ingredient.GetIngredientDTO;
import com.backend.OrderHere.mapper.LinkIngredientDishMapper;
import com.backend.OrderHere.model.Dish;
import com.backend.OrderHere.model.Ingredient;
import com.backend.OrderHere.model.LinkIngredientDish;
import com.backend.OrderHere.repository.DishRepository;
import com.backend.OrderHere.repository.IngredientRepository;
import com.backend.OrderHere.repository.LinkIngredientDishRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkIngredientDishService {
    @Autowired
    private LinkIngredientDishRepository linkIngredientDishRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private LinkIngredientDishMapper linkIngredientDishMapper;

    public LinkIngredientDish createLink(AddIngredientDTO addIngredientDTO) {
        Dish dish = dishRepository.findById(addIngredientDTO.getDishId()).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        Ingredient ingredient = ingredientRepository.findByName(addIngredientDTO.getName()).orElseGet(() -> {
            Ingredient newIngredient = new Ingredient();
            newIngredient.setName(addIngredientDTO.getName());
            newIngredient.setUnit(addIngredientDTO.getUnit());
            return ingredientRepository.save(newIngredient);
        });

        LinkIngredientDish link = new LinkIngredientDish();
        link.setDish(dish);
        link.setIngredient(ingredient);
        link.setQuantityValue(addIngredientDTO.getQuantityValue());
        link.setQuantityUnit(addIngredientDTO.getUnit());

        return linkIngredientDishRepository.save(link);
    }

    public List<GetIngredientDTO> findGetIngredientDTOByDishID(Integer dishID) {
        Dish dish = dishRepository.findById(dishID).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        List<LinkIngredientDish> links = linkIngredientDishRepository.findByDish(dish);
        return links.stream().map(linkIngredientDishMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(DeleteIngredientDTO deleteIngredientDTO) {
        Dish dish = dishRepository.findById(deleteIngredientDTO.getDishID()).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        Ingredient ingredient = ingredientRepository.findById(deleteIngredientDTO.getIngredientID()).orElseThrow(() -> new EntityNotFoundException("Ingredient not found"));
        LinkIngredientDish link = (LinkIngredientDish) linkIngredientDishRepository.findByDishAndIngredient(dish, ingredient).orElseThrow(() -> new EntityNotFoundException("Link not found"));
        linkIngredientDishRepository.delete(link);
    }


}
