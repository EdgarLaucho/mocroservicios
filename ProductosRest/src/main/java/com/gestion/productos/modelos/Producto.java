//el paquete puede ser modelos o entidades
package com.gestion.productos.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45,unique = true,nullable = false)
	private String nombre;
	
	@Column(length = 40,nullable = false)
	private Float precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Producto(Long id, String nombre, Float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(String nombre, Float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(Long id) {
		super();
		this.id = id;
	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
