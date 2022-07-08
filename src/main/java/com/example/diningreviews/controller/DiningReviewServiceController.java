package com.example.diningreviews.controller;

import com.example.diningreviews.domain.Users;
import com.example.diningreviews.repositories.UserRepository;
import com.example.diningreviews.service.DiningReviewService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/dining-reviews")
public class DiningReviewServiceController {

    private DiningReviewService diningReviewService;
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }


    //create a user by unique username
    @PostMapping("/create-user")
    public Users createUser(@RequestBody Users username) {
        var usersOptional = this.userRepository.findUsersByName(username.getName());
        if(usersOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {
            return this.userRepository.save(username);
        }
    }


}
