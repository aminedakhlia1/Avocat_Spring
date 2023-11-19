package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);

}
