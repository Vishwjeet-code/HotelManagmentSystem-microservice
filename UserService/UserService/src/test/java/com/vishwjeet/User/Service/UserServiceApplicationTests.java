package com.vishwjeet.User.Service;

import com.vishwjeet.User.Service.Entity.Rating;
import com.vishwjeet.User.Service.External.Service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}
	@Test
	void createRating(){
		Rating rating = Rating.builder().Ratings(8).hotelId(2L).userId(3L).Feedback("this hotel is nice because this is Vishu's hotel").build();
		Rating CreatedRating =ratingService.CreatRating(rating);
		System.out.println("Rating is created");

	}

}
