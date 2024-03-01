package com.moto.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	
	private String modelo;
	
	private Long usuarioId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Moto(Long id, String marca, String modelo, Long usuarioId) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}

	public Moto(String marca, String modelo, Long usuarioId) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}

	public Moto(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public Moto(Long usuarioId) {
		super();
		this.usuarioId = usuarioId;
	}

	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
