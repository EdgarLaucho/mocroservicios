package com.gestion.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.modelos.Producto;
import com.gestion.productos.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	public List<Producto> listaProducto(){
		return repository.findAll();
	}
	
	public void guardarProducto(Producto producto) {
		repository.save(producto);
		
	}
	
	public Producto obtenerProductoId(Long id) {
		return repository.findById(id).get();
	}
	
	public void eliminarProducto(Long id) {
		repository.deleteById(id);
	}

}
