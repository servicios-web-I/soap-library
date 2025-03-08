package com.example.gardeningstore.repository;

import com.example.gardeningstore.model.Order;
import com.example.gardeningstore.model.OrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderPK> {
    
    // Obtener todas las órdenes de un cliente específico
    List<Order> findByCustomerId(Long customerId);

    // Obtener el total gastado por un cliente en pedidos
    @Query("SELECT SUM(p.price) FROM Order o JOIN o.products p WHERE o.customer.id = :customerId")
    Double getTotalSpentByCustomer(@Param("customerId") Long customerId);
}
