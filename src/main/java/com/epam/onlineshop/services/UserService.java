package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;

public interface UserService {

    User addUser(User user);
    Boolean isExistsByUser(User user);
    Role getRoleByUser(User user);
}
