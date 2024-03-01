package com.inventario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.inventario.entity.ArticuloCarrito;
import com.inventario.entity.Productos;
import com.inventario.entity.Usuario;
import com.inventario.repository.IArticuloRepository;

@DataJpaTest//para los test de jpa
@AutoConfigureTestDatabase(replace = Replace.NONE)//para la configuracion de la base de datos de prueba y buscara no remplazar datos existente importantes
@Rollback(false)// para evitar el revertir las transacciones de la base de datos
public class ArticuloCarritoTest {
	
	@Autowired
	private IArticuloRepository artiRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void anadirArticulo() {
		Productos producto= entityManager.find(Productos.class, 1);
		Usuario usuario= entityManager.find(Usuario.class, 5);
		
		ArticuloCarrito articulo= new ArticuloCarrito("prueba2",5 ,800.00 ,producto ,usuario);
		artiRepo.save(articulo);
	}
	
	@Test
	public void añadirMultiplesArticulos() {
		Usuario usuario =new Usuario((long) 1);
		Productos producto1 = new Productos((long)1);
		Productos producto2 = new Productos((long)2);
		ArticuloCarrito articulo1= new ArticuloCarrito("prueba3",10 ,800.00 ,producto1 ,usuario);
		ArticuloCarrito articulo2= new ArticuloCarrito("prueba4",5 ,800.00 ,producto2 ,usuario);
		artiRepo.saveAll(List.of(articulo1,articulo2));
		
		
	}
	
	@Test
	public void listaArticulos() {
		List<ArticuloCarrito> list =artiRepo.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void actualizarCarrito() {
		ArticuloCarrito articulo= artiRepo.findById((long)1).get();
		articulo.setCantidad(11);
		articulo.setNombre("prueba5");
		articulo.setPrecio(1.00);
		articulo.setProducto(new Productos((long)1));
		
		
	}
	
	@Test
	public void eliminarArticulo() {
		artiRepo.deleteById((long)1);
	}

}
