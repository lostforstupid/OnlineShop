package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@PropertySource("classpath:/application.properties")
public class UserController {

    private final UserService userService;

    @Value("${signin.message.error}")
    private String wrongSignin;

    @Value("${signup.message.error}")
    private String wrongSignup;

    @PostMapping("/registration")
    public ModelAndView registerUser(ModelAndView modelAndView) {
        modelAndView.addObject("newUser", new User());

        modelAndView.setViewName("regist");
        return modelAndView;
    }

    @PostMapping("/signin")
    public ModelAndView signIn(@ModelAttribute("userJSP") User user, ModelAndView modelAndView) {
        if (userService.isExistsByUser(user)) {
            modelAndView.setViewName(getViewName(user));
            modelAndView.addObject("userJSP", user);
        } else {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", this.wrongSignin);
        }
        return modelAndView;
    }

    @PostMapping("/user")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user, ModelAndView modelAndView) {
        User newUser = userService.addUser(user);
        if (null != newUser) {
            modelAndView.setViewName(getViewName(newUser));
            modelAndView.addObject("userJSP", user);
        } else {
            modelAndView.setViewName("regist");
            modelAndView.addObject("newUser", user);
            modelAndView.addObject("message", this.wrongSignup);
        }
        return modelAndView;
    }

    String getViewName(User newUser) {
        String viewName = "";
        switch (userService.getRoleByUser(newUser)) {
            case USER:
                viewName = "welcome";
                break;
            case ADMIN:
                viewName = "admin";
                break;
            case ANONYMOUS:
                viewName = "welcome";
                break;
        }
        return viewName;
    }
}