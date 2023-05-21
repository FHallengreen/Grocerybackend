package com.example.grocerydeliverysystem.repository;


import com.example.grocerydeliverysystem.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRespository extends JpaRepository<Delivery, Integer> {
}
