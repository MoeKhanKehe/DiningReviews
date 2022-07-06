package com.example.diningreviews.controller;

import com.example.diningreviews.domain.Users;
import com.example.diningreviews.repositories.UserRepository;
import com.example.diningreviews.service.DiningReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/dining-reviews")
public class DiningReviewServiceController {

    private DiningReviewService diningReviewService;
    private UserRepository userRepository;

    //create a user
    @PostMapping("/create-user")
    public Users createUser1(@RequestBody Users user) {
        return this.diningReviewService.createUser1(user);
    }

//    create a user
//    @PostMapping("/create")
//    public void createUsers() {
//        Users user = this.userRepository.save(new Users("Moe2","Chicago","Illinois",60176,true,true,false));
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
