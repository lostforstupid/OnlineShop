package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.User;

public interface UserService {

    User addNewUser(User user);
    User signInUser(User user);
    String getViewNameByRole(User user);
}
