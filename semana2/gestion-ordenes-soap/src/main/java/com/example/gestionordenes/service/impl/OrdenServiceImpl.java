package com.example.gestionordenes.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gestionordenes.dto.OrdenDTO;
import com.example.gestionordenes.dto.ProductoDTO;
import com.example.gestionordenes.entity.Orden;
import com.example.gestionordenes.entity.Producto;
import com.example.gestionordenes.repository.OrdenRepository;
import com.example.gestionordenes.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService {

	private final OrdenRepository ordenRepository;

	public OrdenServiceImpl(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}

	@Override
	public OrdenDTO crearOrden(OrdenDTO ordenDTO) {
		// Convertir OrdenDTO a Orden (entidad JPA)
		Orden orden = new Orden();
		orden.setCliente(ordenDTO.getCliente());
		orden.setProductos(ordenDTO.getProductos().stream().map((ProductoDTO productoDTO) -> {
			Producto producto = new Producto();
			producto.setNombre(productoDTO.getNombre());
			producto.setPrecio(productoDTO.getPrecio());
			return producto;
		}).collect(Collectors.toList()));

		// Guardar en la base de datos
		Orden ordenGuardada = ordenRepository.save(orden);

		// Convertir la entidad guardada de vuelta a DTO
		OrdenDTO ordenGuardadaDTO = new OrdenDTO();
		ordenGuardadaDTO.setId(ordenGuardada.getId());
		ordenGuardadaDTO.setCliente(ordenGuardada.getCliente());
		ordenGuardadaDTO.setProductos(ordenGuardada.getProductos().stream().map(producto -> {
			ProductoDTO productoDTO = new ProductoDTO();
			productoDTO.setNombre(producto.getNombre());
			productoDTO.setPrecio(producto.getPrecio());
			return productoDTO;
		}).collect(Collectors.toList()));

		return ordenGuardadaDTO;
	}

	@Override
	public List<OrdenDTO> listarOrdenes() {
		// Recupera las órdenes y las mapea a DTOs
		return ordenRepository.findAll().stream().map(orden -> {
			OrdenDTO dto = new OrdenDTO();
			dto.setId(orden.getId());
			dto.setCliente(orden.getCliente());
			dto.setProductos(orden.getProductos().stream().map(producto -> {
				ProductoDTO productoDTO = new ProductoDTO();
				productoDTO.setNombre(producto.getNombre());
				productoDTO.setPrecio(producto.getPrecio());
				return productoDTO;
			}).collect(Collectors.toList()));
			return dto;
		}).collect(Collectors.toList());
	}
}
