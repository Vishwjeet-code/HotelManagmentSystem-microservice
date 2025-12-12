package com.vishwjeet.hotelService.Controller;

import com.vishwjeet.hotelService.Entity.Hotel;
import com.vishwjeet.hotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;



    @PostMapping
    public ResponseEntity<Hotel>CreatHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.saveHotel(hotel);
        return ResponseEntity.ok(hotel1);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> GetAllHotel(){
        List<Hotel>hotels = hotelService.GetHOTELS();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{Hotel_id}")
        public ResponseEntity<Hotel> GetHotelByID(@PathVariable Long Hotel_id){
        Hotel hotel = hotelService.getHotelbyId(Hotel_id);
        return ResponseEntity.ok(hotel);

        }

}
