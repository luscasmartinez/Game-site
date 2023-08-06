package com.rp3.marco4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.rp3.marco4.domain.Users.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

}
