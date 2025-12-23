package com.userService;

import com.userService.feignConfig.RatingService;
import com.userService.payload.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {


	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

//	@Test
//	void saveRating(){
//		Rating rating=Rating.builder().userId("dlfdfdfhfl").hotelId("ldfslfjslfjs").feedback("this is only for testing purpose of fien").build();
//		ratingService.createRating(rating);
//		System.out.println("rating is created successfully!");
//
//	}

//	@Test
//	void deleteRatingById(){
//	  ratingService.deleteRating("838a0889-199e-411f-82c8-e2cc1e419c7e");
//		System.out.println("rating deleted successfuly!");
//	}

}
