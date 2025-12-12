package com.vishwjeet.hotelService.Service;

import com.vishwjeet.hotelService.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotelbyId(Long Hotel_id);

    List<Hotel>GetHOTELS ();
}
