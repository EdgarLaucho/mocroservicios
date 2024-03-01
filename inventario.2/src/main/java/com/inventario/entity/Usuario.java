package com.inventario.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false, unique = true)
	private String email;

	@Column(length = 45, nullable = false)
	private String password;

	@ManyToMany//(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public void anadirRol(Rol rol) {
		this.roles.add(rol);
	}
	
	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
	}

	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Usuario(Long id, String email, String password, Set<Rol> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String email, String password, Set<Rol> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + "]";
	}

	
}
