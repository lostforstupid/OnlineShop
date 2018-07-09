package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.User;

public interface UserService {
    User signInUser(User user);
    String getViewNameByRole(User user);
    boolean addNewUser(User user);
}
