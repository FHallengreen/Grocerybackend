package com.example.grocerydeliverysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryRequest {

    private LocalDate date;
    private String warehouse;
    private String destination;

    public DeliveryRequest(LocalDate date, String warehouse, String destination) {
        this.date = date;
        this.warehouse = warehouse;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "DeliveryRequest{" +
                "date=" + date +
                ", fromWarehouse='" + warehouse + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
