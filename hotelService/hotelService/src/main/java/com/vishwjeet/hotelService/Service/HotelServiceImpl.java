package com.vishwjeet.hotelService.Service;

import com.vishwjeet.hotelService.Entity.Hotel;
import com.vishwjeet.hotelService.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelbyId(Long Hotel_id) {
        return hotelRepository.findById(Hotel_id).orElseThrow(
                ()->new IllegalArgumentException("their is no hotel in data base by this id "+Hotel_id));
    }

    @Override
    public List<Hotel> GetHOTELS() {
        return hotelRepository.findAll();
    }
}
