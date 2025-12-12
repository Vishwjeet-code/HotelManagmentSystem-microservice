package com.vishwjeet.RatingService.Service;

import com.vishwjeet.RatingService.Entity.Rating;

import java.util.List;

public interface RatingService {

    Rating creatRating(Rating rating);

   List<Rating> getRatingsByUserID(Long user_id);

    List<Rating> getAllRatings();

    List<Rating>getAllHotelRating(Long hotel_id);
}
