package com.hospitalService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private  String about;


}
