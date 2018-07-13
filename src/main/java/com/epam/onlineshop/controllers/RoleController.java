package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import com.epam.onlineshop.services.impl.UserServiceImpl;

public class RoleController {

    public boolean addRoles() {
        UserService userService = new UserServiceImpl();
        User user = userService.findById(1);

        return true;
    }
}
