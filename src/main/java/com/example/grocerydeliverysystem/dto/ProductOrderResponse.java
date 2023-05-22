package com.example.grocerydeliverysystem.dto;

import com.example.grocerydeliverysystem.entities.Delivery;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.entities.ProductOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductOrderResponse {

    int id;
    int quantity;
    DeliveryResponse delivery;
    ProductResponse product;

    public ProductOrderResponse(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.quantity = productOrder.getQuantity();
        this.delivery = new DeliveryResponse(productOrder.getDelivery());
        this.product = new ProductResponse(productOrder.getProduct());
    }
}
