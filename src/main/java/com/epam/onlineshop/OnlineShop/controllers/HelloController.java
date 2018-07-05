package com.epam.onlineshop.OnlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World! Online Shop will be here soon!";
    }
}
