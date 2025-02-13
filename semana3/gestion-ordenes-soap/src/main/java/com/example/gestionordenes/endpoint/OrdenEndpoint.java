package com.example.gestionordenes.endpoint;

import com.example.gestionordenes.dto.OrdenDTO;
import com.example.gestionordenes.dto.ProductoDTO;
import com.example.gestionordenes.service.OrdenService;
import com.example.soap.gestionordenes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class OrdenEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap/gestionordenes";

    @Autowired
    private OrdenService ordenService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "crearOrdenRequest")
    @ResponsePayload
    public CrearOrdenResponse crearOrden(@RequestPayload CrearOrdenRequest request) {
        // Convertir CrearOrdenRequest a OrdenDTO
        OrdenDTO orden = new OrdenDTO();
        orden.setCliente(request.getCliente());
        orden.setProductos(
                request.getProductos().stream()
                        .map(producto -> {
                            ProductoDTO nuevoProducto = new ProductoDTO();
                            nuevoProducto.setNombre(producto.getNombre());
                            nuevoProducto.setPrecio(producto.getPrecio());
                            return nuevoProducto;
                        }).collect(Collectors.toList())
        );

        // Guardar la orden
        OrdenDTO nuevaOrden = ordenService.crearOrden(orden);

        // Crear la respuesta
        CrearOrdenResponse response = new CrearOrdenResponse();
        response.setOrdenId(nuevaOrden.getId());
        response.setCliente(nuevaOrden.getCliente());
        response.getProductos().addAll(
                nuevaOrden.getProductos().stream()
                        .map(prod -> {
                            Producto producto = new Producto();
                            producto.setNombre(prod.getNombre());
                            producto.setPrecio(prod.getPrecio());
                            return producto;
                        }).collect(Collectors.toList())
        );

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listarOrdenesRequest")
    @ResponsePayload
    public ListarOrdenesResponse listarOrdenes(@RequestPayload ListarOrdenesRequest request) {
        // Obtener las órdenes como DTOs
        List<OrdenDTO> ordenes = ordenService.listarOrdenes();

        // Crear la respuesta SOAP
        ListarOrdenesResponse response = new ListarOrdenesResponse();
        response.getOrdenes().addAll(
                ordenes.stream().map(orden -> {
                    com.example.soap.gestionordenes.Orden soapOrden = new com.example.soap.gestionordenes.Orden();
                    soapOrden.setId(orden.getId());
                    soapOrden.setCliente(orden.getCliente());
                    soapOrden.getProductos().addAll(
                            orden.getProductos().stream()
                                    .map(prod -> {
                                        Producto producto = new Producto();
                                        producto.setNombre(prod.getNombre());
                                        producto.setPrecio(prod.getPrecio());
                                        return producto;
                                    }).collect(Collectors.toList())
                    );
                    return soapOrden;
                }).collect(Collectors.toList())
        );

        return response;
    }
}
