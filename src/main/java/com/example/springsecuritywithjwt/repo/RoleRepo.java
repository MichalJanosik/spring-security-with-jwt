package com.example.springsecuritywithjwt.repo;

import com.example.springsecuritywithjwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
