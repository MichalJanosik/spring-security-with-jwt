package com.example.springsecuritywithjwt.repo;

import com.example.springsecuritywithjwt.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
