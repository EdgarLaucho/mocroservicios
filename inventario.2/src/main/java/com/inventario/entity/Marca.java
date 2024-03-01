package com.inventario.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@OneToMany
	@JoinColumn(name = "marca_id")
	private List<Categoria> categorias = new ArrayList<>();

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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Marca(Long id, String nombre, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca(Long id) {
		super();
		this.id = id;
	}

	public Marca(String nombre, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}
