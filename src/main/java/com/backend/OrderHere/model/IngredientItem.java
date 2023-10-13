package com.backend.OrderHere.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "ingredientitems")
public class IngredientItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredientitems_id", nullable = false)
    private Long ingredientItemsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredients ingredient;

    @Column(name = "quantity_value", nullable = false)
    private Double quantityValue;

    @Column(name = "quantity_unit", nullable = false)
    private String quantityUnit;

   
}





