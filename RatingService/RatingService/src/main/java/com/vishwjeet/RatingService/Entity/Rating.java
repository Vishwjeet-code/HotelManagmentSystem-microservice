package com.vishwjeet.RatingService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RatingId;
    private Long userId;
    private Long hotelId;
    private int Ratings;
    private String Feedback;
}
