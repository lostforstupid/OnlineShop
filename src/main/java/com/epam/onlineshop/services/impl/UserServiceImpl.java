package com.epam.onlineshop.services.impl;

import com.epam.onlineshop.entities.Role_enum;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public boolean addUser(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null) {
            return false;
        } else {
            userRepository.save(User.builder()
                    .roleEnum(Role_enum.USER)
                    .username(username)
                    //.roles.add()
                    .isBlocked(false)
                    .password(bCryptPasswordEncoder.encode(user.getPassword()))
                    .address(user.getAddress())
                    .build());
            return true;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role_enum getRoleByUsername(String username) {
        return userRepository.findByUsername(username).getRoleEnum();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);

        if (result != null) {
            User user = result.get();
            return user;
        }

        return null;
    }

    @Override
    public boolean changeBlockedStatus(User user) {
        user.setIsBlocked(!user.getIsBlocked());
        return userRepository.save(user) != null;
    }
}
