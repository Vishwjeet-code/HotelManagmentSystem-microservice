package com.vishwjeet.User.Service.Entity;

import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Rating {
    private Long RatingId;
    private Long userId;
    private Long hotelId;
    private int Ratings;
    private String Feedback;
    private Hotel hotel;
}
