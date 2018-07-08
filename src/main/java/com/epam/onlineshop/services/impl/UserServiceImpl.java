package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {

        if (userRepository.findByUsername(user.getUsername()) == null) {
            User newUser = new User("user", user.getUsername(), user.getPassword(), false, user.getAddress());
            userRepository.saveAndFlush(newUser);
            return newUser;
        }
        // TODO Added check when user is already exist.
        return user;
    }

    @Override
    public String checkUserInSystem(User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());
        if ((byUsername != null) && ((byUsername.getPassword().equals(user.getPassword())))) {
            return "welcome";
        } else {
            return "wrong_enter";
        }
    }
}
