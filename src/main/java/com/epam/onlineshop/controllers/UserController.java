package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newUser", new User());
        modelAndView.setViewName("regist");
        return modelAndView;
    }

    @PostMapping("/signin")
    public ModelAndView signIn(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView;
        if (null != userService.signInUser(user)) {
            modelAndView = new ModelAndView(userService.getViewNameByRole(user));
            modelAndView.addObject("userJSP", user);
        } else {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "Username or Password is wrong!!");
        }
        return modelAndView;
    }

    @PostMapping("/user")
    public ModelAndView addNewUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.addNewUser(user)) {
            modelAndView.setViewName("welcome");
            modelAndView.addObject("userJSP", user);
        } else {
            modelAndView.setViewName("regist");
            modelAndView.addObject("newUser", user);
            modelAndView.addObject("registerErrorMessage", "User with this login is already exists.");
        }
        return modelAndView;
    }
}