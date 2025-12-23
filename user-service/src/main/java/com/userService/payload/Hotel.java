package com.userService.payload;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private  String about;
}
