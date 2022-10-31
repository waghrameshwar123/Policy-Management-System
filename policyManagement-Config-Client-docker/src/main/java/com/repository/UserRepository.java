package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);
    User findByUserId(String userId);
    User findByEmail(String email);
    User save(User user);
}
