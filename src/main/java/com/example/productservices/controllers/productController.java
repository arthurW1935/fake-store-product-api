package com.example.productservices.controllers;

import com.example.productservices.models.Product;
import com.example.productservices.services.FakeStoreProductServices;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class productController {

    private FakeStoreProductServices ProductServices;
    public  productController(FakeStoreProductServices ProductServices){
        this.ProductServices = ProductServices;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return ProductServices.getProductById(id);
    }

    @GetMapping("/product/")
    public List<Product> getAllProduct() {
        return ProductServices.getAllProduct();
    }

    @PostMapping("/product/")
    public Product createProduct(@RequestBody Product product) {
        return ProductServices.createProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return ProductServices.updateProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        return ProductServices.deleteProduct(id);
    }
}
