package com.example.grocerydeliverysystem.api;

import com.example.grocerydeliverysystem.dto.DeliveryRequest;
import com.example.grocerydeliverysystem.dto.DeliveryResponse;
import com.example.grocerydeliverysystem.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/create")
    public ResponseEntity<DeliveryResponse> createDelivery(@RequestBody DeliveryRequest deliveryRequest){
        System.out.println();
    return deliveryService.createDelivery(deliveryRequest);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<DeliveryResponse>> findAllDeliveries(){
        return deliveryService.findAllDeliveries();
    }

}
