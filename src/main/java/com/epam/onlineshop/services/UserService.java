package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

public interface UserService {

    User addUser(User user);
    Boolean isExistsByUsername(String username);
    Role getRoleByUser(User user);
}
