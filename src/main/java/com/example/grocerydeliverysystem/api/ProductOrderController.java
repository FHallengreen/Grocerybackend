package com.example.grocerydeliverysystem.api;

import com.example.grocerydeliverysystem.dto.ProductOrderRequest;
import com.example.grocerydeliverysystem.entities.Delivery;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.entities.ProductOrder;
import com.example.grocerydeliverysystem.repository.DeliveryRespository;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/productorder")
public class ProductOrderController {

    @Autowired
    private DeliveryRespository deliveryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @PostMapping("/create/{deliveryId}")
    public ResponseEntity<String> createProductOrders(@PathVariable int deliveryId, @RequestBody List<ProductOrderRequest> productOrderRequests) {

        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);

        if (deliveryOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Delivery with id: " + deliveryId + " not found");
        }

        Delivery delivery = deliveryOptional.get();
        List<ProductOrder> productOrders = new ArrayList<>();

        for (ProductOrderRequest productOrderRequest : productOrderRequests) {
            Optional<Product> productOptional = productRepository.findById(productOrderRequest.getProductId());

            if (productOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("Product with id: " + productOrderRequest.getProductId() + " not found");
            }

            Product product = productOptional.get();

            ProductOrder productOrder = new ProductOrder();
            productOrder.setQuantity(productOrderRequest.getQuantity());
            productOrder.setProduct(product);
            productOrder.setDelivery(delivery);

            productOrders.add(productOrder);
        }

        productOrderRepository.saveAll(productOrders);
        return ResponseEntity.ok().body("ProductOrders created successfully for delivery with id: " + deliveryId);
    }
}