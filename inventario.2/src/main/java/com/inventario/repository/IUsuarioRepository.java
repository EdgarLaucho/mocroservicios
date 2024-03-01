package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
