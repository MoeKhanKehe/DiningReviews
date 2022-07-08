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
    //allow user to create a user by unique username
    public DiningReviewService(UserRepository userRepository, Users users) {
        this.userRepository = userRepository;
        this.users = users;
    }

    public void createUser(Users users) {
        userRepository.save(users);
        System.out.print("Successfully added the user");
    }

}
