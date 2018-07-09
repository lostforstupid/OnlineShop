package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public boolean addNewUser(User user) {

        String username = user.getUsername();

        if (null != userRepository.findByUsername(username)) {
                return false;
        } else {
            userRepository.save(User.builder()
                    .role(Role.USER)
                    .username(username)
                    .isBlocked(false)
                    .password(user.getPassword())
                    .address(user.getAddress())
                    .build());
            return true;
        }
    }

    @Override
    public User signInUser(User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());

        if ((byUsername != null) && ((byUsername.getPassword().equals(user.getPassword())))) {
            return byUsername;
        } else {
            return null;
        }
    }

    @Override
    public String getViewNameByRole(User user) {
        switch (user.getRole()) {
            case ADMIN:
                return "admin";
            case USER:
                return "welcome";
            case ANONYMOUS:
                return "welcome";
            default:
                return "welcome";
        }
    }
}
