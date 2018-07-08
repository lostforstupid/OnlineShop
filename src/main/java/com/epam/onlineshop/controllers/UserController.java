package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registration")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newUser", new User());
        modelAndView.setViewName("regist");
        return modelAndView;
    }

    @PostMapping("/enter")
    public ModelAndView signIn(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(userService.checkUserInSystem(user));
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

    @PostMapping("/add_new_user")
    public ModelAndView addNewUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("userJSP", userService.addNewUser(user));
        return modelAndView;
    }
}