package com.epam.onlineshop.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping({"/","/welcome"})
    public String main(Map<String, Object> model) {
        return "main";
    }

    @PostMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        return "main";
    }
}

