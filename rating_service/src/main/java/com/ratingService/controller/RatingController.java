package com.ratingService.controller;

import com.ratingService.entities.Rating;
import com.ratingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;
    //create rating
    @PostMapping("/")

    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        rating.setRatingId(UUID.randomUUID().toString());
        return new ResponseEntity<>(ratingRepository.save(rating), HttpStatus.OK);
    }
    //findByRatingId

    @GetMapping("/rating/{ratingId}")
    public ResponseEntity<Rating> getByRatingId(@PathVariable("ratingId") String ratingId){
        return new ResponseEntity<>(ratingRepository.findById(ratingId).get(),HttpStatus.CREATED);
    }
    //find by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable("userId") String userId){
        return new ResponseEntity<>(ratingRepository.findByUserId(userId),HttpStatus.CREATED);
    }
    //findByhotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<?> getByHotelId(@PathVariable("hotelId") String hotelId){
        return new ResponseEntity<>(ratingRepository.findByHotelId(hotelId),HttpStatus.CREATED);
    }
    //findAll
    @GetMapping("/")
    public ResponseEntity<?> getAllRating(){
        return new ResponseEntity<>(ratingRepository.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{ratingId}")
    public ResponseEntity<?> deleteRating(@PathVariable("ratingId") String ratingId){
        ratingRepository.deleteById(ratingId);
        return ResponseEntity.ok("deleted!! rating");
    }
}
