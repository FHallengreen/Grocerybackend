package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.dto.ProductRequest;
import com.example.grocerydeliverysystem.dto.ProductResponse;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setWeight(productRequest.getWeight());
        productRepository.save(product);

        return new ProductResponse(product);

    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());

    }

    public ResponseEntity<ProductResponse> getProductByName(String name) {

        Product product = productRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));

        return ResponseEntity.ok(new ProductResponse(product));
    }

    public ResponseEntity<ProductResponse> getProductById(int id) {

        ProductResponse response = productRepository.findById(id)
                .map(ProductResponse::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ProductResponse> updateProduct(int id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setWeight(productRequest.getWeight());
        productRepository.save(product);

        return ResponseEntity.ok(new ProductResponse(product));

    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
