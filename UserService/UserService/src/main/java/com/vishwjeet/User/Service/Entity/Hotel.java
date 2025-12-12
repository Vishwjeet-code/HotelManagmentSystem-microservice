package com.vishwjeet.User.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private  Long ID;
    private  String Name;
    private String Location;
    private  String About;
}
