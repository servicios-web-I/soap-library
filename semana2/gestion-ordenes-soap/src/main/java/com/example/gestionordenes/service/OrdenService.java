package com.example.gestionordenes.service;

import com.example.gestionordenes.dto.OrdenDTO;

import java.util.List;

public interface OrdenService {
	OrdenDTO crearOrden(OrdenDTO orden);
    List<OrdenDTO> listarOrdenes();
}
