package com.inventario.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Productos {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(length = 128,nullable = false,unique = true)
	 private String nombre;
	 
	 private float precio;
	 
	 @ManyToOne
	 @JoinColumn(name= "categoria_id")
	 private Categoria categoria;
	 
	 @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
	 private List<ProductoDetalle> detalle= new ArrayList<>();
	 

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void añadirDetalle(String nombre, String valor) {
		this.detalle.add(new ProductoDetalle(nombre,valor,this));
	}

	public List<ProductoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<ProductoDetalle> detalle) {
		this.detalle = detalle;
	}
	
	public void setDetalle(Long id, String nombre, String valor) {
		this.detalle.add(new ProductoDetalle(id,nombre,valor,this));
		
	}
	 
	
	public Productos(Long id, String nombre, float precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Productos(String nombre, float precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Productos(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Productos(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + "]";
	}
	
	

}
