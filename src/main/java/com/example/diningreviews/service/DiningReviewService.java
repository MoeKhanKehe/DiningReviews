package com.example.diningreviews.service;

import com.example.diningreviews.domain.Users;
import com.example.diningreviews.repositories.UserRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
@Builder
public class DiningReviewService {

    private UserRepository userRepository;
    private Users users;

    public DiningReviewService(UserRepository userRepository, Users users) {
        this.userRepository = userRepository;
        this.users = users;
    }

    //allow user to create a user by unique username
    public Users createUser(String name) {
        //create the user
        Users user = Users.builder()
                .name(name)
                .city("Chicago")
                .state("Illinois")
                .zipCode(60618)
                .interestedInEggAllergies(false)
                .interestedInPeanutAllergies(false)
                .interestedInDairyAllergies(false)
                .build();
        return userRepository.save(user);
    }

    public Users createUser1(Users user) {
        Users users1 = userRepository.save(user);
        return users1;
    }
}
