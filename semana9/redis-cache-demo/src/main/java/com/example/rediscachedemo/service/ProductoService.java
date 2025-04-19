package com.example.rediscachedemo.service;

import com.example.rediscachedemo.model.Producto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductoService {
    private final Map<Long, Producto> bdSimulada = new HashMap<>();

    public ProductoService() {
        // Simulando productos en "base de datos"
        bdSimulada.put(1L, new Producto(1L, "Laptop", 1200.00));
        bdSimulada.put(2L, new Producto(2L, "Smartphone", 800.00));
        bdSimulada.put(3L, new Producto(3L, "Tablet", 500.00));
    }

    @Cacheable(value = "productos", key = "#id")
    public Producto obtenerProducto(Long id) {
        System.out.println("Buscando producto en la base de datos...");
        return bdSimulada.get(id);
    }

    @CacheEvict(value = "productos", key = "#id")
    public void eliminarProductoDelCache(Long id) {
        System.out.println("Producto eliminado de la caché con ID: " + id);
    }
}
