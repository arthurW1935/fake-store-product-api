package com.example.productservices.services;

import java.util.*;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.dtos.fakeStoreProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductServices implements ProductService{
    private RestTemplate restTemplate = new RestTemplate();
    public Product getProductById(Long id) {

        fakeStoreProductDto fakeStoreProduct =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                fakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProduct.getId());
        product.setName(fakeStoreProduct.getTitle());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setImageUrl(fakeStoreProduct.getImageUrl());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    public List<Product> getAllProduct() {
        fakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                fakeStoreProductDto[].class);

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

    public Product createProduct(Product product) {
        fakeStoreProductDto fakeStoreProduct = new fakeStoreProductDto();
        fakeStoreProduct.setTitle(product.getName());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageUrl());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        fakeStoreProductDto createdFakeStoreProduct = restTemplate.postForObject(
                "https://fakestoreapi.com/products/",
                fakeStoreProduct,
                fakeStoreProductDto.class);

        return product;
    }

    public Product updateProduct(Product product, Long id) {
        fakeStoreProductDto fakeStoreProduct = new fakeStoreProductDto();
        fakeStoreProduct.setTitle(product.getName());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageUrl());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        restTemplate.put(
                "https://fakestoreapi.com/products/" + id,
                fakeStoreProduct);

        return product;
    }

    public Product deleteProduct(Long id) {
        Product product = getProductById(id);
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        return product;
    }


}
