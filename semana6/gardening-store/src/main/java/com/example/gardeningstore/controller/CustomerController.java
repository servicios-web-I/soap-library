package com.example.gardeningstore.controller;

import com.example.gardeningstore.model.Customer;
import com.example.gardeningstore.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (customer.getName() == null || customer.getEmail() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(customerRepository.save(customer));
    }
}
