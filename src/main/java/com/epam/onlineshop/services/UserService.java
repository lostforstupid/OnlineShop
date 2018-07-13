package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role_enum;
import com.epam.onlineshop.entities.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    Role_enum getRoleByUsername(String username);

    User findByUsername(String username);

    List<User> getAllUsers();

    boolean changeBlockedStatus(User user);

    User findById(Long id);
}
