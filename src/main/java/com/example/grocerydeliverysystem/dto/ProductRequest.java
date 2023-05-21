package com.example.grocerydeliverysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    String name;
    double price;
    double weight;

    public ProductRequest(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
