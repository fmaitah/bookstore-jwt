package com.fin.fintechbookstore.repositories;

import com.fin.fintechbookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String Username);

}