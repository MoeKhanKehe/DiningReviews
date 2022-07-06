package com.example.diningreviews.repositories;

import com.example.diningreviews.domain.DiningReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiningReviewRepository extends JpaRepository<DiningReview, UUID> {
}

