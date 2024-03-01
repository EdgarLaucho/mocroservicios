package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.entity.ArticuloCarrito;

public interface IArticuloRepository extends JpaRepository<ArticuloCarrito, Long> {

}
