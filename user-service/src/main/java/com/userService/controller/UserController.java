package com.userService.controller;

import com.userService.entity.User;
import com.userService.feignConfig.HotelService;
import com.userService.payload.Hotel;
import com.userService.payload.Rating;
import com.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    //create user

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        String s = UUID.randomUUID().toString();
        user.setUserId(s);
        return ResponseEntity.ok().body(userRepository.save(user));
    }


    //find one user
    @GetMapping("/{userId}")
    public ResponseEntity<?> getOneUser(@PathVariable("userId") String userId){
        User user = userRepository.findById(userId).get();
        System.out.println(user.toString());
        //calling second service rating
        //http://localhost:8083/ratings/users/928cbf9b-dfc1-43f8-bfd0-7235aefa4eb5
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(forObject).collect(Collectors.toList());
        //ratings aa gayi aur ratings se hotel bhi nikalne hai to uske liye alag se
        ratings.forEach(rating -> {
//            rating.getHotelId();
           // Hotel hotel = restTemplate.getForObject("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
            //ye rest template se nikalne ka treeka hai
            //aur niche feign client se nikalne ka treeka hai
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);//aise hi aap rating wating sabka kar skte hai feing client se

        });
        user.setRatings(ratings);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    //fina all user
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
            List<Rating> ratings = Arrays.stream(forObject).collect(Collectors.toList());
            //ratings aa gayi aur ratings se hotel bhi nikalne hai to uske liye alag se
            ratings.forEach(rating -> {
//            rating.getHotelId();
              //  Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class); //ye rest template se nikalne ka treeka hai
               //aur niche feign client se nikalne ka treeka hai


                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
            });
            user.setRatings(ratings);
        });
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }
}
