package com.vishwjeet.User.Service.Service;

import com.vishwjeet.User.Service.Entity.Hotel;
import com.vishwjeet.User.Service.Entity.Rating;
import com.vishwjeet.User.Service.Entity.User;
import com.vishwjeet.User.Service.External.Service.HotelService;
import com.vishwjeet.User.Service.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User SaveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> GetAllUser() {

        return userRepository.findAll();

       //  http://localhost:8081/Users/2
    }

    @Override
    public User GetUser(Long User_id) {
        User user= userRepository.findById(User_id).orElseThrow(()->
                new IllegalArgumentException("there is no user in data base related to this ID "+User_id));
        // http://localhost:8083/Ratings/UserId/1
       Rating [] RaitingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/Users/"+user.getID(), Rating[].class);

       logger.info("{}", RaitingsOfUser);

        List<Rating> Ratings = Arrays.stream(RaitingsOfUser).toList();
//        http://localhost:8082/Hotels/1
        Arrays.stream(RaitingsOfUser).map(rating -> {
           // Hotel hotel =restTemplate.getForObject("http://HOTEL-SERVICE/Hotels/"+rating.getHotelId(), Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);
           return rating;
        }).collect(Collectors.toList());

       user.setRatings(Ratings);
        return user;
    }
}
