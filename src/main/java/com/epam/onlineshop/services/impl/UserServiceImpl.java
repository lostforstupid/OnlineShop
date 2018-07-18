package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Transactional
    @Override
    public boolean addUser(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null) {
            return false;
        } else {
            userRepository.save(User.builder()
                    .role(Role.USER)
                    .username(username)
                    .firstName("")
                    .isBlocked(false)
                    .password(bCryptPasswordEncoder.encode(user.getPassword()))
                    .address(user.getAddress())
                    .build());
            logger.info("User" + username + "was added!");
            return true;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        User updatedUser = userRepository.findByUsername(user.getUsername());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setFirstName(user.getFirstName());
        userRepository.save(updatedUser);
        logger.info("User" + user.getUsername() + "was updated!");
    }

    @Override
    public Role getRoleByUsername(String username) {
        return userRepository.findByUsername(username).getRole();
    }
}
