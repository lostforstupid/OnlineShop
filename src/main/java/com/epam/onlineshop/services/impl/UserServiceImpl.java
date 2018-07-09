package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User addUser(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null) {
            return null;
        } else {
            return userRepository.save(User.builder()
                    .role(Role.USER)
                    .username(username)
                    .isBlocked(false)
                    .password(user.getPassword())
                    .address(user.getAddress())
                    .build());
        }
    }

    @Override
    public Boolean isExistsByUser(User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());
        return (byUsername != null) && ((byUsername.getPassword().equals(user.getPassword())));
    }

    @Override
    public Role getRoleByUser(User user) {
        return userRepository.findByUsername(user.getUsername()).getRole();
    }
}
