package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.dto.ProductRequest;
import com.example.grocerydeliverysystem.dto.ProductResponse;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductServiceTest {

ProductService productService;
@Autowired
ProductRepository productRepository;

    Product product;
    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);

        product = new Product();
        product.setName("Milk");
        product.setPrice(10);
        product.setWeight(1);
        productRepository.save(product);
    }

    @Test
    void createProduct() {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Apple");
        productRequest.setPrice(2);
        productRequest.setWeight(0.3);

      ProductResponse response = productService.createProduct(productRequest);

        assertEquals("Apple", response.getName());

        Optional<Product> optionalProduct = productRepository.findByName("Apple");

        assertTrue(optionalProduct.isPresent());
        Product product = optionalProduct.get();

        // Verify that the product's details are correct
        assertEquals("Apple", product.getName());
        assertEquals(2, product.getPrice());
        assertEquals(0.3, product.getWeight());

    }

    @Test
    void getProducts() {
        productService.getProducts();

        assertEquals(1, productRepository.findAll().size());
    }

    @Test
    void getProductByName() {
        ProductResponse response = productService.getProductByName("Milk");

        assertEquals("Milk", response.getName());
        assertEquals(10, response.getPrice());
        assertEquals(1, response.getWeight());
    }

    @Test
    void updateProduct() {

        productService.updateProduct(1, new ProductRequest("Milk", 20, 1));
        Optional<Product> optionalProduct = productRepository.findById(1);
        assertTrue(optionalProduct.isPresent());
        Product product = optionalProduct.get();
        assertEquals(20, product.getPrice());

    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(product.getId());
        List<Product> products = productRepository.findAll();
        System.out.println("Products: " + products);
        assertEquals(0, productRepository.findAll().size());

    }
}