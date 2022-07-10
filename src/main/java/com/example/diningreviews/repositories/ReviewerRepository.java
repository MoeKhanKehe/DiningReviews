package com.example.diningreviews.repositories;

import com.example.diningreviews.domain.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, UUID> {

    Optional<Reviewer> findUsersByName(String username);

}
