package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    Role getRoleByUsername(String username);

    User findByUsername(String username);

    List<User> getAllUsers();

    boolean changeBlockedStatus(User user);

    User findById(Long id);
}
