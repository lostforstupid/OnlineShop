package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.repository.RoleRepository;
import com.epam.onlineshop.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
