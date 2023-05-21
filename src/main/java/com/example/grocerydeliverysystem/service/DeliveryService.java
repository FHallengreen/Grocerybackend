package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.dto.DeliveryRequest;
import com.example.grocerydeliverysystem.dto.DeliveryResponse;
import com.example.grocerydeliverysystem.entities.Delivery;
import com.example.grocerydeliverysystem.repository.DeliveryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRespository deliveryRespository;

    public ResponseEntity<DeliveryResponse> createDelivery(DeliveryRequest deliveryRequest){
        System.out.println(deliveryRequest);
        Delivery delivery = new Delivery();
        delivery.setDate(deliveryRequest.getDate());
        delivery.setWarehouse(deliveryRequest.getWarehouse());
        delivery.setDestination(deliveryRequest.getDestination());
        deliveryRespository.save(delivery);
        DeliveryResponse deliveryResponse = new DeliveryResponse(delivery);

        return ResponseEntity.ok(deliveryResponse);
    }

    public ResponseEntity<List<DeliveryResponse>> findAllDeliveries() {

        List<Delivery> deliveries = deliveryRespository.findAll();
        List<DeliveryResponse> deliveryResponses = deliveries.stream()
                .map(DeliveryResponse::new).toList();
        return ResponseEntity.ok().body(deliveryResponses);
    }
}
