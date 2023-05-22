package com.example.grocerydeliverysystem.repository;

import com.example.grocerydeliverysystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

}
