package com.example.grocerydeliverysystem.dto;

import com.example.grocerydeliverysystem.entities.Delivery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryResponse {

    int id;
    LocalDate date;
    String warehouse;
    String destination;

    public DeliveryResponse(Delivery d){
        this.id = d.getId();
        this.date = d.getDate();
        this.warehouse = d.getWarehouse();
        this.destination = d.getDestination();
    }
}
