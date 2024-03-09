package com.example.productservices.controllers;

import java.util.*;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.services.FakeStoreCategoryServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class categoryController {

    private FakeStoreCategoryServices categoryServices;
    public categoryController(FakeStoreCategoryServices categoryServices){
        this.categoryServices = categoryServices;
    }

    @GetMapping("/product/category/{category_name}")
    public List<Product> getProductsByCategory(@PathVariable("category_name") String category_name) {
        return categoryServices.getProductsByCategory(category_name);
    }

    @GetMapping("product/category/")
    public List<Category> getAllCategory() {
        return categoryServices.getAllCategory();
    }
}
