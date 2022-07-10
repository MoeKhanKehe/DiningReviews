package com.example.diningreviews.service;

import com.example.diningreviews.domain.Reviewer;
import com.example.diningreviews.repositories.ReviewerRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
@Builder
public class DiningReviewService {

    private ReviewerRepository reviewerRepository;
    private Reviewer reviewer;
    //allow user to create a user by unique username
    public DiningReviewService(ReviewerRepository reviewerRepository, Reviewer reviewer) {
        this.reviewerRepository = reviewerRepository;
        this.reviewer = reviewer;
    }

    public void createUser(Reviewer reviewer) {
        reviewerRepository.save(reviewer);
        System.out.print("Successfully added the user");
    }

}
