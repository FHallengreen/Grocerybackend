package com.example.grocerydeliverysystem.dto;

import com.example.grocerydeliverysystem.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {

    int id;
    String name;
    double price;
    double weight;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.weight = p.getWeight();
    }

}
