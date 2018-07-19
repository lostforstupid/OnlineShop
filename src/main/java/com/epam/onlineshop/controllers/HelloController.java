package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Role;
import com.epam.onlineshop.entities.User;
import com.epam.onlineshop.repository.ProductRepository;
import com.epam.onlineshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final ProductService productService;

    private final ProductRepository productRepository;

    private final UserService userService;

    @GetMapping({"/","/welcome"})
    public ModelAndView main(@RequestParam(value = "page", required = false) Integer numOfPage) {
        int numOfProductsOnPage = 3;
        if((numOfPage == null)||(numOfPage<0)) {
            numOfPage = 0;
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userService.findByUsername(username);

        String viewName = getViewName(loggedInUser.getRole());
        ModelAndView modelAndView = new ModelAndView(viewName);


        Pageable page = new PageRequest(numOfPage, numOfProductsOnPage, Sort.by("name"));
        Slice<Product> slice = null;
        slice = productRepository.findAll(page);
        List<Product> product = slice.getContent();
        for (Product products:product) {
            System.out.println(products.getName());
        }
        modelAndView.addObject(product);
        int numOfPages = (int) (productRepository.count()/numOfProductsOnPage);
        if(((int) (productRepository.count()/numOfProductsOnPage))!=0){
            numOfPages++;
        }
        modelAndView.addObject("pages", numOfPages);
        //modelAndView.addObject(productService.getAllProducts());
        modelAndView.addObject("product", new Product());

        return modelAndView;
    }

    @GetMapping("/deny-access")
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

