package com.example.grocerydeliverysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductOrderRequest {

    private int productId;
    private int quantity;
}
