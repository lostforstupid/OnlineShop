package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean isUserValidated(String password, String username);

    Role getRoleByUsername(String username);

    // Remove
    List<User> findAll();
}
