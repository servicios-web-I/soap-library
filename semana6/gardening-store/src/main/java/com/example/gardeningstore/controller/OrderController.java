package com.example.gardeningstore.controller;

import com.example.gardeningstore.model.Customer;
import com.example.gardeningstore.model.Order;
import com.example.gardeningstore.model.OrderPK;
import com.example.gardeningstore.model.Product;
import com.example.gardeningstore.repository.CustomerRepository;
import com.example.gardeningstore.repository.OrderRepository;
import com.example.gardeningstore.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order orderRequest) {

        Optional<Customer> customerOpt = customerRepository.findById(orderRequest.getCustomer().getId());
        if (customerOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Customer does not exist.");
        }

        List<Product> productList = productRepository.findAllById(
            orderRequest.getProducts().stream().map(Product::getId).toList()
        );

        if (productList.size() != orderRequest.getProducts().size()) {
            return ResponseEntity.badRequest().body("One or more products do not exist.");
        }

        OrderPK orderPK = new OrderPK();
        orderPK.setId(orderRequest.getId().getId());
        orderPK.setCustomerId(orderRequest.getCustomer().getId());

        Order newOrder = new Order();
        newOrder.setId(orderPK);
        newOrder.setOrderDate(new Date());
        newOrder.setCustomer(customerOpt.get());
        newOrder.setProducts(productList);

        Order savedOrder = orderRepository.save(newOrder);
        return ResponseEntity.ok(savedOrder);
    }
}
