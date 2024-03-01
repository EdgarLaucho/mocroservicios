package com.inventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.inventario.entity.Categoria;
import com.inventario.repository.ICategoria;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {

	@Autowired
	private  ICategoria repository;
	
	@Test
	public void crearCategoria() {
		Categoria categoriaGuardada= repository.save(new Categoria("Electronico"));
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}
}
