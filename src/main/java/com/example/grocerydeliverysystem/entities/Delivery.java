package com.example.grocerydeliverysystem.entities;

import com.example.grocerydeliverysystem.dto.DeliveryRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    private String warehouse;
    private String destination;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;


}
