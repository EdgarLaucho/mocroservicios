package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.entity.Categoria;

public interface ICategoria extends JpaRepository<Categoria, Long> {

}
