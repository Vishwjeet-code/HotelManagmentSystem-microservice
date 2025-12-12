package com.vishwjeet.hotelService.Repository;

import com.vishwjeet.hotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
