package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.ProductInOrder;
import com.epam.onlineshop.services.ProductInOrderService;
import com.epam.onlineshop.services.security.SecurityService;
import com.epam.onlineshop.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;
    private final ProductInOrderService productInOrderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView openRegistrationForm(ModelAndView model) {
        model.addObject("userJSP", new User());
        model.setViewName("registration");
        return model;
    }

    @GetMapping(value = "/logout")
    public ModelAndView openRegistrationForm(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        model.setViewName("redirect:/login?logout");
        return model;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView openProfile(ModelAndView model, Principal principal) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addObject("userJSP", currentUser);
        List<ProductInOrder> allOrdersByUser = productInOrderService.findAllOrderedByUser(currentUser);
        model.addObject("products", allOrdersByUser);
        model.setViewName("profile");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editProfile(ModelAndView model, Principal principal) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addObject("userJSP", currentUser);
        model.setViewName("edit_profile");
        return model;
    }

    @PostMapping(value = "/registration")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user, BindingResult bindingResult, ModelAndView model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            model.setViewName("registration");
        } else {
            userService.addUser(user);
            securityService.autologin(user.getUsername(), user.getPassword());
            model.setViewName("redirect:/login");
        }
        return model;
    }

    @GetMapping(value = "/login")
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

    @GetMapping("/users")
    public ModelAndView getAllUsers(@ModelAttribute("user") User user, ModelAndView model) {
        model.setViewName("main_admin_users");
        model.addObject("user", new User());
        model.addObject(userService.getAllUsers());
        return model;
    }

    @PostMapping("/users/{id}/block")
    public ModelAndView changeBlockedStatus(@PathVariable Long id) {
        User user = userService.findById(id);

        if ((user != null) && (user.getRole() != Role.ADMIN)) {
            userService.changeBlockedStatus(user);
        }

        return new ModelAndView("redirect:/users");
    }

    String getViewNameByRole(Role userRoleEnum) {
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