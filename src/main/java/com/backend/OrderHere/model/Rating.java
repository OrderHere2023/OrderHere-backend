package com.backend.OrderHere.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import java.util.UUID;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id", nullable = false)
    private UUID ratingId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "dish_id", nullable = false)
    private Integer dishId;

    @Column(name = "rating_value", nullable = false)
    private Double ratingValue;

    @Column(name = "comments")
    private String comments;

    @Column(name = "create_at", nullable = false)
    private Timestamp createdAt;
}
