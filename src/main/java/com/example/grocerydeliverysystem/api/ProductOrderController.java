package com.example.grocerydeliverysystem.api;

import com.example.grocerydeliverysystem.dto.ProductOrderRequest;
import com.example.grocerydeliverysystem.dto.ProductOrderResponse;
import com.example.grocerydeliverysystem.repository.DeliveryRespository;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import com.example.grocerydeliverysystem.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/productorder")
public class ProductOrderController {

    ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductOrderResponse> createProductOrders(@RequestBody ProductOrderRequest productOrderRequests) {


        ProductOrderResponse productOrder = productOrderService.createProductOrders(productOrderRequests).getBody();

        return ResponseEntity.ok(productOrder);
        }

        @GetMapping("/findall")
    public ResponseEntity<List<ProductOrderResponse>> findAllProductOrders(){
            return productOrderService.findAllProductOrders();
        }

        @DeleteMapping("/delete/{id}")
    public void deleteProductOrder(@PathVariable("id") int id){
            productOrderService.deleteProductOrder(id);
        }

    }