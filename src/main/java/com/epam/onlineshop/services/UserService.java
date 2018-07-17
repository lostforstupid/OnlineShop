package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

public interface UserService {

    boolean addUser(User user);

    Role getRoleByUsername(String username);

    User findByUsername(String username);

    void updateUser(User user);
}
