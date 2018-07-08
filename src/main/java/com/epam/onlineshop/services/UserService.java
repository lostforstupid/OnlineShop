package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.User;

public interface UserService {

    User addNewUser(User user);
    String checkUserInSystem(User user);
}
