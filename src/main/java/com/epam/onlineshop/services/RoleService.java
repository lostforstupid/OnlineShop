package com.epam.onlineshop.services;

import com.epam.onlineshop.entities.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role findByName(String name);
}
