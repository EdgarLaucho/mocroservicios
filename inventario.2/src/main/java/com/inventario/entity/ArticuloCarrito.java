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
@Table(name="articulo_carrito")
public class ArticuloCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45,nullable = false,unique = true)
	private String nombre;
	
	private int cantidad;
	
	@Column(length = 25,nullable = false)
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Productos producto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArticuloCarrito(Long id, String nombre, int cantidad, Double precio, Productos producto, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito(String nombre, int cantidad, Double precio, Productos producto, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito(String nombre, Double precio, Productos producto, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.producto = producto;
		this.usuario = usuario;
	}
	

	public ArticuloCarrito(Long id) {
		super();
		this.id = id;
	}

	public ArticuloCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ArticuloCarrito [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", producto=" + producto + ", usuario=" + usuario + "]";
	}
	
	
	
	
}
