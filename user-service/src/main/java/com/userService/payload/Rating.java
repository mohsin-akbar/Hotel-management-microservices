package com.userService.payload;

import lombok.Builder;
import lombok.Data;

@Data

public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;

    private String feedback;
    private Hotel hotel;

}
