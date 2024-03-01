package com.inventario.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45,nullable = false,unique = true)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;

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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria(Long id, String nombre, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
	}

	public Categoria(String nombre, Marca marca) {
		super();
		this.nombre = nombre;
		this.marca = marca;
	}

	public Categoria(Marca marca) {
		super();
		this.marca = marca;
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	
	
}
