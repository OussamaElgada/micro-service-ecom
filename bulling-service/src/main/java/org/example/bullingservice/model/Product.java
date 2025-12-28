package org.example.bullingservice.model;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
