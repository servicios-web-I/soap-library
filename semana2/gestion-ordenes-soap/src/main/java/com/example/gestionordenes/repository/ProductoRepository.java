package com.example.gestionordenes.repository;

import com.example.gestionordenes.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
