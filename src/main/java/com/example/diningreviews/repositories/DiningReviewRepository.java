package com.example.diningreviews.repositories;

import com.example.diningreviews.domain.DiningReview;
import com.example.diningreviews.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DiningReviewRepository extends JpaRepository<DiningReview, UUID> {
    List<DiningReview> findByStatusAndRestaurantName(Status status, String restaurantName);
}

