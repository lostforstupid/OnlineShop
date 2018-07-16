package com.epam.onlineshop.controllers;

import com.epam.onlineshop.services.ProductInOrderService;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ProductInOrderService productInOrderService;
    private final UserService userService;

    @GetMapping(value = "/cart")
    public ModelAndView openCart(ModelAndView model, Principal principal) {
        model.addObject("products", productInOrderService.findAllNewByUser(
                userService.findByUsername(principal.getName())));
        model.setViewName("cart");
        return model;
    }

    @GetMapping(value = "/cart/order")
    public ModelAndView deleteProduct(ModelAndView model, Principal principal) {
        productInOrderService.makeOrder(userService.findByUsername(principal.getName()));
        model.setViewName("redirect:/cart");
        return model;
    }

    @RequestMapping(value = "/cart/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("id") Long id, ModelAndView model) {
        productInOrderService.deleteById(id);
        model.setViewName("redirect:/cart");
        return model;
    }

    @RequestMapping(value = "/cart/{id}/inc", method = RequestMethod.GET)
    public ModelAndView incrementCount(@PathVariable("id") Long id, ModelAndView model) {
        productInOrderService.incrementCount(id);
        model.setViewName("redirect:/cart");
        return model;
    }

    @RequestMapping(value = "/cart/{id}/decrement", method = RequestMethod.GET)
    public ModelAndView decrementCount(@PathVariable("id") Long id, ModelAndView model) {
        if (productInOrderService.getCountById(id) > 1) {
            productInOrderService.decrementCount(id);
        } else {
            productInOrderService.deleteById(id);
        }
        model.setViewName("redirect:/cart");
        return model;
    }
}
