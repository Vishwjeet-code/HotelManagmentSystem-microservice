package com.vishwjeet.User.Service.Controller;


import com.vishwjeet.User.Service.Entity.User;
import com.vishwjeet.User.Service.Service.UserService;
import com.vishwjeet.User.Service.Service.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User user1=userService.SaveUser(user);
        return ResponseEntity.ok(user1);
    }


    @GetMapping({"/{User_Id}"})
   // @CircuitBreaker(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback" )
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> GetUser(@PathVariable Long User_Id){
        User user = userService.GetUser(User_Id);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallback( Long User_Id,Exception e){

       e.printStackTrace();
        System.out.println("Fallback is executed because service is down : "+e.getMessage());
        User user = User.builder()
                .Name("dummy").
                Email("dummy@mail.com").
                About("This user is dummy because some service is down").ID(111L).build();
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userService.GetAllUser();
        return ResponseEntity.ok(users);
    }
}
