package com.gestion.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.productos.modelos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
