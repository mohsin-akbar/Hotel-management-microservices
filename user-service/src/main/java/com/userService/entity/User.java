package com.userService.entity;

import com.userService.payload.Hotel;
import com.userService.payload.Rating;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name ="users" )
public class User {

    @Id
    private String userId;

    private String name;
    private String mobile;
    private String username;

    @Transient
    private List<Rating> ratings=new ArrayList<>();



}
