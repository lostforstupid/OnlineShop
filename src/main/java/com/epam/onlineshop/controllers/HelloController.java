package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Role_enum;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping({"/","/welcome"})
    public String main(Map<String, Object> model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userService.findByUsername(username);
        return getViewName(loggedInUser.getRoleEnum());
    }

    @PostMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userService.findByUsername(username);
        return getViewName(loggedInUser.getRoleEnum());
    }

    private String getViewName(Role_enum roleEnum) {
        switch (roleEnum) {
            case ADMIN:
                return "redirect:/admin/users";
            default:
                return "main";
        }
    }
}

