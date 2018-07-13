package com.epam.onlineshop.controllers;

import lombok.RequiredArgsConstructor;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final static String WRONG_SIGNIN = "Username or Password is wrong!";
    private final static String WRONG_SIGNUP = "This username is already exist!";

    @GetMapping(value = "/registration")
    public ModelAndView registration(ModelAndView model) {
        model.addObject("newUser", new User());
        model.setViewName("registration");
        return model;
    }

    @PostMapping(value = "/registration")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user, ModelAndView model) {
        if (userService.addUser(user)) {
            model.setViewName("welcome");
            model.addObject("userJSP", user);
        } else {
            model.setViewName("registration");
            model.addObject("newUser", user);
            model.addObject("registerErrorMessage", WRONG_SIGNUP);
        }
        return model;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userJSP") User user, ModelAndView model) {
        if (userService.isUserValidated(user.getPassword(), user.getUsername())) {
            Role userRole = userService.getRoleByUsername(user.getUsername());
            model.setViewName(getViewNameByRole(userRole));
            model.addObject("userJSP", user);
        } else {
            model.setViewName("index");
            model.addObject("message", WRONG_SIGNIN);
        }
        return model;
    }

    @GetMapping("/admin/users")
    public ModelAndView getAllUsers(@ModelAttribute("user") User user, ModelAndView model) {
        model.setViewName("main_admin_users");
        model.addObject("user", new User());
        model.addObject(userService.getAllUsers());
        return model;
    }

    @PostMapping("admin/users/{id}/block")
    public ModelAndView changeBlockedStatus(@PathVariable Long id) {
        User user = userService.findById(id);

        if (user.getRole() != Role.ADMIN) {
            userService.changeBlockedStatus(id);
        }

        return new ModelAndView("redirect:/admin/users");
    }

    String getViewNameByRole(Role userRole) {
        switch (userRole) {
            case USER:
                return "main";
            case ADMIN:
                return "main_admin";
            case ANONYMOUS:
                return "main";
            default:
                return "main";
        }
    }
}
