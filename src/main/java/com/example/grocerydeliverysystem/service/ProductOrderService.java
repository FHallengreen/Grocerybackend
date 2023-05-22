package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.dto.ProductOrderRequest;
import com.example.grocerydeliverysystem.dto.ProductOrderResponse;
import com.example.grocerydeliverysystem.entities.Delivery;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.entities.ProductOrder;
import com.example.grocerydeliverysystem.repository.DeliveryRespository;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    DeliveryRespository deliveryRespository;

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductOrderResponse> createProductOrders(ProductOrderRequest productOrderRequests) {

        Delivery delivery = deliveryRespository.findById(productOrderRequests.getDeliveryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery not found"));
        Product product = productRepository.findById(productOrderRequests.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
        int quantity = productOrderRequests.getQuantity();

        ProductOrder productOrder = new ProductOrder();
        productOrder.setDelivery(delivery);
        productOrder.setProduct(product);
        productOrder.setQuantity(quantity);
        productOrderRepository.save(productOrder);

        ProductOrderResponse productOrderResponse = new ProductOrderResponse(productOrder);

        return ResponseEntity.ok(productOrderResponse);
    }

    public ResponseEntity<List<ProductOrderResponse>> findAllProductOrders(){
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        List<ProductOrderResponse> productOrderResponses = productOrders.stream()
                .map(ProductOrderResponse::new)
                .toList();
        return ResponseEntity.ok(productOrderResponses);
    }

    public void deleteProductOrder(int id) {
        productOrderRepository.deleteById(id);
    }
}
