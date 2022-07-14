package com.example.diningreviews.controller;

import com.example.diningreviews.domain.*;
import com.example.diningreviews.repositories.DiningReviewRepository;
import com.example.diningreviews.repositories.RestaurantRepository;
import com.example.diningreviews.repositories.ReviewerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/dining-reviews")
public class DiningReviewController {

    private ReviewerRepository reviewerRepository;
    private DiningReviewRepository diningReviewRepository;
    private RestaurantRepository restaurantRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    //------------------------------------USER------------------------------------------------//

    //create a user by unique username
    @PostMapping("/create-user")
    public Reviewer createUser(@RequestBody Reviewer username) {
        var usersOptional = this.reviewerRepository.findUsersByName(username.getName());
        if(usersOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {
            return this.reviewerRepository.save(username);
        }
    }

    //update user profile
    @PutMapping("update-user")
    public String updateUser(@RequestBody Reviewer reviewer) {
        Optional<Reviewer> usersOptional = reviewerRepository.findUsersByName(reviewer.getName());
        //exists in the table? - yes = update - no = create/add
        if(usersOptional.isPresent()) {
            final Reviewer reviewerToUpdate = usersOptional.get();
            reviewerToUpdate.setCity(reviewer.getCity());
            reviewerToUpdate.setState(reviewer.getState());
            reviewerToUpdate.setZipCode(reviewer.getZipCode());
            reviewerToUpdate.setInterestedInDairyAllergies(reviewer.isInterestedInDairyAllergies());
            reviewerToUpdate.setInterestedInEggAllergies(reviewer.isInterestedInEggAllergies());
            reviewerToUpdate.setInterestedInPeanutAllergies(reviewer.isInterestedInPeanutAllergies());
            reviewerRepository.save(reviewerToUpdate);
            return "Successfully Updated!";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
        }
    }

    // find user by name
    @GetMapping("/users/{username}")
    public Optional<Reviewer> findUserByName(@PathVariable("username") String username) {
        Optional<Reviewer> usersOptional = reviewerRepository.findUsersByName(username);
        if(usersOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return reviewerRepository.findUsersByName(username);
    }

    // check if user exists from name when they submit a dining review
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public boolean doesUserExist(String name) {
        return reviewerRepository.findUsersByName(name).isPresent();
    }


    //------------------------------------DINING REVIEW---------------------------------------//


    //as a user I want to submit a new dining review
    @PostMapping("/new-review")
    public DiningReview createDiningReview(@RequestBody DiningReview diningReview) {
        return diningReviewRepository.save(diningReview);
    }

    //as an admin get a list of all dining reviews
    @GetMapping()
    public List<DiningReview> getAllDiningReviews() {
        return diningReviewRepository.findAll();
    }

    //as an admin approve or reject a review
    public void approveOrDenyReview(DiningReview diningReview, Status status) {
        diningReview.setStatus(status);
    }

    // get all approved dining reviews for restaurant when updating restaurant scored
    public List<DiningReview> getAllApprovedReviewsForRestaurant(Restaurant restaurant) {
        return diningReviewRepository.findByStatusAndRestaurantName(Status.APPROVED, restaurant.getName());
    }


    //------------------------------------RESTAURANT------------------------------------------//

    // submit new restaurant | can't create restaurant with same name + zip
//    @PostMapping("/new-restaurant")


    //find restaurant by id
    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@RequestParam UUID id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isPresent()) {
            return optionalRestaurant;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    //find restaurant by zip and have at least one user-submitted score for allergy | sorted in descending
}
