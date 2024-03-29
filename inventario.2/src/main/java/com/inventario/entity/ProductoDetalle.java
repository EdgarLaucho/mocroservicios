package com.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto_detalle")
public class ProductoDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String nombre;
	
	@Column(length = 45, nullable = false)
	private String valor;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Productos producto;

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public ProductoDetalle(Long id, String nombre, String valor, Productos producto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalle(String nombre, String valor, Productos producto) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return nombre + " - " + valor;
	}
	
	
	
}
