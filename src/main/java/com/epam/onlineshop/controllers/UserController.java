package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/enter")
    public ModelAndView welcome(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        // Заглушка
        addDummyUser();
        //
        User byUsername = userRepository.findByUsername(user.getUsername());
        if ((byUsername != null) && ((byUsername.getPassword().equals(user.getPassword())))) {
            modelAndView.setViewName("welcome");
            modelAndView.addObject("userJSP", byUsername);
        } else {
            modelAndView.setViewName("wrong_enter");
            modelAndView.addObject("userJSP", new User());
        }
        return modelAndView;
    }

    private void addDummyUser() {
        User newUser = new User("admin", "admin", "123", false, "address");
        if (userRepository.findByUsername(newUser.getUsername()) == null)
            userRepository.saveAndFlush(newUser);
    }

    @RequestMapping("/add_new_user")
    public ModelAndView addNewUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userRepository.findByUsername(user.getUsername()) == null) {
            User newUser = new User("user", user.getUsername(), user.getPassword(), false, user.getAddress());
            userRepository.saveAndFlush(newUser);
            modelAndView.setViewName("welcome");
            modelAndView.addObject("userJSP", newUser);
        }
        return modelAndView;
    }
}