package com.epam.onlineshop.controllers;

import com.epam.onlineshop.services.security.SecurityService;
import com.epam.onlineshop.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import com.epam.onlineshop.entities.Role_enum;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView model) {
        model.addObject("userJSP", new User());
        model.setViewName("registration");
        return model;
    }

    @PostMapping(value = "/registration")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user, BindingResult bindingResult, ModelAndView model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            model.setViewName("registration");
        }else {
            userService.addUser(user);
            securityService.autologin(user.getUsername(), user.getPassword());
            model.setViewName("redirect:/login");
        }

        //model.setViewName("redirect:/login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model, String error, String logout) {
        if (error != null) {
            model.addObject("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addObject("message", "You have been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }

    @Secured("ROLE_ADMIN")
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

        if ((user != null) && (user.getRoleEnum() != Role_enum.ADMIN)) {
            userService.changeBlockedStatus(user);
        }

        return new ModelAndView("redirect:/admin/users");
    }

    String getViewNameByRole(Role_enum userRoleEnum) {
        switch (userRoleEnum) {
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