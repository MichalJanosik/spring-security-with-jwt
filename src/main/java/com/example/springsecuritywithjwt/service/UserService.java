package com.example.springsecuritywithjwt.service;

import com.example.springsecuritywithjwt.domain.AppUser;
import com.example.springsecuritywithjwt.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
