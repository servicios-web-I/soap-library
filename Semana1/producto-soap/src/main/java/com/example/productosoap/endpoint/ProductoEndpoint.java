package com.example.productosoap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ejemplo.productos.GetProductoRequest;
import com.ejemplo.productos.GetProductoResponse;

@Endpoint
public class ProductoEndpoint {

    private static final String NAMESPACE_URI = "http://ejemplo.com/productos";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getProducto(@RequestPayload GetProductoRequest request) {
        GetProductoResponse response = new GetProductoResponse();
        
        // Simulación: si id = 1, retorna producto ejemplo
        if (request.getId() == 1) {
            response.setNombre("Laptop");
            response.setPrecio(999.99);
        } else {
            response.setNombre("Producto no encontrado");
            response.setPrecio(0.0);
        }

        return response;
    }
}

