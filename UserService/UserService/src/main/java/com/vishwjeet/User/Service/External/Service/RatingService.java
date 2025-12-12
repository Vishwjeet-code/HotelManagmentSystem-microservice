package com.vishwjeet.User.Service.External.Service;

import com.vishwjeet.User.Service.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name = "Rating-service")
public interface RatingService {

    @PostMapping("/Ratings")
    Rating CreatRating(Rating rating);

    @PutMapping("/Ratings/{ratingId}")
    Rating UpdateRating(@PathVariable Long ratingId,Rating rating);

    @DeleteMapping("/Ratings/{ratingId}")
    void DeleteRatinng(@PathVariable Long ratingId);

}
