package com.example.grocerydeliverysystem.config;

import com.example.grocerydeliverysystem.entities.Delivery;
import com.example.grocerydeliverysystem.entities.Product;
import com.example.grocerydeliverysystem.repository.DeliveryRespository;
import com.example.grocerydeliverysystem.repository.ProductOrderRepository;
import com.example.grocerydeliverysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DeveloperData implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private DeliveryRespository deliveryRespository;

    @Override
    public void run(ApplicationArguments args) {


        Product product1 = new Product();
        product1.setName("Apple");
        product1.setPrice(10);
        product1.setWeight(1);
        productRepository.save(product1);

        Delivery delivery1 = new Delivery();
        delivery1.setDate(LocalDate.now().plusDays(6));
        delivery1.setDestination("Copenhagen");
        delivery1.setWarehouse("Aarhus");
        deliveryRespository.save(delivery1);

    }
}
