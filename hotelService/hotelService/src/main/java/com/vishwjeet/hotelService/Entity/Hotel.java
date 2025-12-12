package com.vishwjeet.hotelService.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID;
    @Column(nullable = false,length = 150)
    private  String Name;

    private String Location;
    private  String About;

}
