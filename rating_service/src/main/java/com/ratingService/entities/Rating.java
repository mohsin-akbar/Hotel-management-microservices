package com.ratingService.entities;

import com.ratingService.payload.Hotel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ratings")
@Data

public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;

    private String feedback;

    @Transient
    private Hotel hotel;

}