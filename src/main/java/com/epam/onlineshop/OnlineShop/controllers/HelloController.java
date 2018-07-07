package com.epam.onlineshop.OnlineShop.controllers;

import org.springframework.stereotype.Controller;
import com.epam.onlineshop.OnlineShop.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String main(Map<String, Object> model) {
        model.put("userJSP", new User());
        return "index";
    }

    @RequestMapping("/registration")
    public String registration(Map<String, Object> model) {
        model.put("newUser", new User());
        return "regist";
    }
}
