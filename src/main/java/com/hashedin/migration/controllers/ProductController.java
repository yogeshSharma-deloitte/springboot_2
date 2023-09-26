package com.hashedin.migration.controllers;

import com.hashedin.migration.entity.Product;
import com.hashedin.migration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MstfDryl
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public void getAllProducts(){
        Product product = new Product();
        Long count = userService.getProductCount();
        System.out.println(count);
    }

}