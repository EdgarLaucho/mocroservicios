package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.entity.Productos;

public interface ProductoRepository extends JpaRepository<Productos,Long > {

}
