package com.vishwjeet.RatingService.Controller;


import com.vishwjeet.RatingService.Entity.Rating;
import com.vishwjeet.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;



    @PostMapping
    public ResponseEntity<Rating> creatRating(@RequestBody Rating rating){
       Rating rating1= ratingService.creatRating(rating);
        return ResponseEntity.ok(rating1);
    }



    @GetMapping("/Users/{UserId}")
    public ResponseEntity<List<Rating>>getAllRatingsByUserId(@PathVariable Long UserId){
        List<Rating> ratings = ratingService.getRatingsByUserID(UserId);
        return ResponseEntity.ok(ratings);
    }
    @GetMapping("/Hotels/{HotelId}")
    public ResponseEntity<List<Rating>>getAllRatingsByHotelId(@PathVariable Long HotelId){
        List<Rating> ratings = ratingService.getAllHotelRating(HotelId);
        return ResponseEntity.ok(ratings);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }
}

