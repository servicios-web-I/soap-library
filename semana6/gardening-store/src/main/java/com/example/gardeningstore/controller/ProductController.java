package com.example.gardeningstore.controller;

import com.example.gardeningstore.model.Category;
import com.example.gardeningstore.model.Product;
import com.example.gardeningstore.repository.CategoryRepository;
import com.example.gardeningstore.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (product.getCategory() == null || product.getCategory().getId() == null) {
            return ResponseEntity.badRequest().body("Category ID is required.");
        }

        // Buscar la categoría en la base de datos
        Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
        if (category.isEmpty()) {
            return ResponseEntity.badRequest().body("Category does not exist.");
        }

        product.setCategory(category.get());

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
}
