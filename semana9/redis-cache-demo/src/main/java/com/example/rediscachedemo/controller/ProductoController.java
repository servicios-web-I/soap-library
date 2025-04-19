package com.example.rediscachedemo.controller;

import com.example.rediscachedemo.model.Producto;
import com.example.rediscachedemo.service.ProductoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    @DeleteMapping("/{id}/cache")
    public String eliminarProductoDelCache(@PathVariable Long id) {
        productoService.eliminarProductoDelCache(id);
        return "Producto eliminado del caché.";
    }
}
