package com.backend.OrderHere.model;

import com.backend.OrderHere.model.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "table_number", nullable = false)
    private Integer tableNumber;

    @Column(name = "reservation_time", nullable = false)
    private ZonedDateTime reservationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false)
    private ZonedDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false)
    private ZonedDateTime updatedTime;
}

