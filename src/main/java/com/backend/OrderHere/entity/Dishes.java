package com.backend.OrderHere.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "Dishes")
public class Dishes {
    public static enum DishAvailability {
        AVAILABLE("Available"),
        SOLD_OUT("Sold Out");
        
        private final String displayName;

        DishAvailability(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
    @Id
    @Column(name = "dish_id", nullable = false)
    private UUID DishId;

    @Column(name = "dish_name", nullable = false)
    private String DishName;

    //description
    @Column(name = "description", nullable = true)
    private String Description;
    
    //price
    @Column(name = "price", nullable = false,precision = 10, scale = 2)
    private BigDecimal Price;

    //image url
    @Column(name = "image_url", nullable = true)
    private String ImageUrl;

    //category
    @Column(name = "category", nullable = false)
    private String Category;

    //rating
    @Column(name = "rating", nullable = true,precision = 10, scale = 2)
    private BigDecimal Rating;

    //restaurant id
    @Column(name = "restaurant_id", nullable = false)
    private Integer RestaurantId;

    //availability
    @Enumerated(EnumType.STRING)
    @Column(name = "availability", nullable = false)
    private DishAvailability Availability;

    //created at
    @Column(name = "created_at", nullable = false)
    private LocalDateTime CreatedAt;

    //updated at
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime UpdatedAt;
}
