package com.example.productservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
}
