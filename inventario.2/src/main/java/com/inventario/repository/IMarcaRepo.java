package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.entity.Marca;

public interface IMarcaRepo extends JpaRepository<Marca, Long> {

}
