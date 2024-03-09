package com.example.productservices.services;

import java.util.*;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.dtos.fakeStoreProductDto;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCategoryServices {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Category> getAllCategory() {
        String[] fakeStoreCategories = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);

        List<Category> categories = new ArrayList<>();
        for (String fakeStoreCategory : fakeStoreCategories) {
            Category category = new Category();
            category.setName(fakeStoreCategory);
            categories.add(category);
        }

        return categories;
    }

    public List<Product> getProductsByCategory(String category_name) {
        fakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category_name, fakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (fakeStoreProductDto fakeStoreProduct : fakeStoreProducts) {
            Product product = new Product();
            product.setId(fakeStoreProduct.getId());
            product.setName(fakeStoreProduct.getTitle());
            product.setDescription(fakeStoreProduct.getDescription());
            product.setPrice(fakeStoreProduct.getPrice());
            product.setImageUrl(fakeStoreProduct.getImageUrl());
            product.setCategory(new Category());
            product.getCategory().setName(fakeStoreProduct.getCategory());
            products.add(product);
        }

        return products;
    }
}
