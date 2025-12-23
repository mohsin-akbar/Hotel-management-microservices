package com.userService.feignConfig;

import com.userService.payload.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.Path;

@Service
@FeignClient(name = "RATING-SERVICE")

public interface RatingService {
    //post
    @PostMapping("/ratings/")
    Rating createRating(Rating rating);//request body isme nahi karte hai but @pathvariable karte hai
  //get

    //put

//    //delete
//    @DeleteMapping("/{ratingId}")
//    void deleteRating(@PathVariable String ratingId);

}
