package com.example.diningreviews.controller;

import com.example.diningreviews.domain.Users;
import com.example.diningreviews.repositories.UserRepository;
import com.example.diningreviews.service.DiningReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    //------------------------------------USER------------------------------------------------//

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

    //update user profile
    @PutMapping("update-user")
    public String updateUser(@RequestBody Users user) {
        Optional<Users> usersOptional = userRepository.findUsersByName(user.getName());
        //exists in the table? - yes = update - no = create/add
        if(usersOptional.isPresent()) {
            final Users userToUpdate = usersOptional.get();
            userToUpdate.setCity(user.getCity());
            userToUpdate.setState(user.getState());
            userToUpdate.setZipCode(user.getZipCode());
            userToUpdate.setInterestedInDairyAllergies(user.isInterestedInDairyAllergies());
            userToUpdate.setInterestedInEggAllergies(user.isInterestedInEggAllergies());
            userToUpdate.setInterestedInPeanutAllergies(user.isInterestedInPeanutAllergies());
            userRepository.save(userToUpdate);
            return "Successfully Updated!";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    // find user by name
    @GetMapping("/user")
    public Optional<Users> findUserByName(@RequestParam String username) {
        Optional<Users> usersOptional = userRepository.findUsersByName(username);
        if(usersOptional.isPresent()) {
            return userRepository.findUsersByName(username);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    // check if user exists from name when they submit a dining review
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods


    //------------------------------------DINING REVIEW---------------------------------------//


    //as an admin submit a new dining review



    //as an admin get a list of all dining reviews



    //as an admin approve or reject a review



    // get all approved dining reviews for restaurant when updating restaurant scored


    //------------------------------------RESTAURANT------------------------------------------//

    // submit new restaurant | cant create restaurant with same name + zip


    //find restaurant by id


    //find restaurant by zip and have at least one user-submitted score for allergy | sorted in descending
}
