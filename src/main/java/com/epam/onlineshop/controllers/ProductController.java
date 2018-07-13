package com.epam.onlineshop.controllers;

import com.epam.onlineshop.entities.Product;
import com.epam.onlineshop.entities.Role_enum;
import com.epam.onlineshop.services.ProductService;
import com.epam.onlineshop.utils.ImageWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/catalog")
    public ModelAndView showProducts() {
        ModelAndView catalog = new ModelAndView();
        catalog.addObject(productService.getAllProducts());
        catalog.addObject("product", new Product());
        catalog.setViewName(getViewName(Role_enum.ADMIN)); //access to admin page is open for all users for now
                                                        // (will be changed after the addition of sessions)
        return catalog;
    }

    @PostMapping("/catalog")
    public ModelAndView addProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
        ModelAndView catalog = new ModelAndView();
        long currentTime = new Date().getTime();
        String name = String.valueOf(currentTime);
        catalog = ImageWriter.writeImage(catalog, file, name);
        product.setImageLink(name + ".jpg");
        product.setCount(100); //TEMPORARY
        productService.addNewProduct(product);
        catalog.addObject(productService.getAllProducts());
        return catalog;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/products")
    public ModelAndView getAllProducts(ModelAndView model) {
        model.setViewName("main_admin_products");
        model.addObject(productService.getAllProducts());
        return model;
    }

    @GetMapping("/admin/products/{id}/edit")
    public ModelAndView editProduct(@PathVariable Long id,  ModelAndView model) {
        model.setViewName("edit_product");
        model.addObject(productService.getProductById(id));
        return model;
    }

    @PostMapping("/admin/products/{id}/save")
    public ModelAndView saveProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return new ModelAndView("redirect:/admin/products");
    }

    @PostMapping("/admin/products/{id}/delete")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ModelAndView("redirect:/admin/products");
    }

    private String getViewName(Role_enum roleEnum) {
        switch (roleEnum) {
            case ADMIN:
                return "main_admin";
            default:
                return "main";
        }
    }
}
