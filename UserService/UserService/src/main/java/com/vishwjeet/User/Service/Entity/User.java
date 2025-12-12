package com.vishwjeet.User.Service.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(length = 50, nullable = false)
    private String Name;
    @Column(unique = true)
    private String Email;

    private LocalDate DOB;
    private  String About;

    @Transient
    private List<Rating> Ratings = new ArrayList<>();


}
