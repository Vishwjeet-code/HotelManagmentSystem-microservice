package com.vishwjeet.RatingService.Service;

import com.vishwjeet.RatingService.Entity.Rating;
import com.vishwjeet.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceIMp implements RatingService{
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating creatRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingsByUserID(Long user_id) {
        return ratingRepository.findByUserId(user_id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllHotelRating(Long hotel_id) {
        return ratingRepository.findByHotelId(hotel_id);
    }
}
