package com.backend.OrderHere.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column(name = "unit", nullable = false)
    private String unit;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false)
    private ZonedDateTime createdTime;
  
    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false)
    private ZonedDateTime updatedTime;

}