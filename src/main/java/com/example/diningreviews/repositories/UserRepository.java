package com.example.diningreviews.repositories;

import com.example.diningreviews.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    //needs to allow the user to create a user by unique username
    public List<Users> findUsersByName(String username);
    public Users findUsersById(UUID uuid);

}
