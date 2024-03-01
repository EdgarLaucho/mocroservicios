package com.gestion.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.modelos.Producto;
import com.gestion.productos.service.ProductoService;

@RestController
public class ProductoControler {
	
	@Autowired
	private ProductoService servicios;
	
	@GetMapping("/productos")
	public List<Producto> listaProducto() {
		return servicios.listaProducto();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
		try {
			Producto producto = servicios.obtenerProductoId(id);
			
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/productos/guardar")
	public void RegistrarProducto(@RequestBody Producto producto) {
		servicios.guardarProducto(producto);
	}
	
	@PutMapping("/producto/actualizar/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Long id){
		try {
			Producto productoExistente= servicios.obtenerProductoId(id);
			
			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());
			servicios.guardarProducto(productoExistente);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/producto/eliminar/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		servicios.eliminarProducto(id);
	}
}
