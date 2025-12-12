package com.vishwjeet.User.Service.External.Service;

import com.vishwjeet.User.Service.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("hotels/{HotelId}")
    Hotel getHotel(@PathVariable Long HotelId);
}
