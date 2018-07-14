package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping({"/","/welcome"})
    public String main(Map<String, Object> model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userService.findByUsername(username);
        return getViewName(loggedInUser.getRole());
    }

    @PostMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/deny_access")
    public ModelAndView denyAccess() {
        return new ModelAndView("access_denied");
    }

    private String getViewName(Role role) {
        switch (role) {
            case ADMIN:
                return "redirect:/users";
            default:
                return "main";
        }
    }
}

