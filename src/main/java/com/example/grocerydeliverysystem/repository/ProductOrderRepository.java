package com.example.grocerydeliverysystem.repository;

import com.example.grocerydeliverysystem.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}
