package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

public interface UserService {

    User addNewUser(User user);
    boolean existsByUser(User user);
    Role getRoleByUser(User user);
}
