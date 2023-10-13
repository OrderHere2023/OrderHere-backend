package com.backend.OrderHere.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String openingHours;

    @Column(nullable = false)
    private String closedDays;

    @Column
    private Double averageRating;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false)
    private OffsetDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false)
    private OffsetDateTime updatedTime;
}
