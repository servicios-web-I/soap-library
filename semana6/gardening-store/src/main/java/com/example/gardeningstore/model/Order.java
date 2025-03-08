package com.example.gardeningstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Order {
    @EmbeddedId
    private OrderPK id;

    @Column(nullable = false)
    private Date orderDate;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "id"),
            @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
        },
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
