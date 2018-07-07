package com.epam.onlineshop.OnlineShop.controllers;

import org.springframework.stereotype.Controller;
import com.epam.onlineshop.OnlineShop.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
