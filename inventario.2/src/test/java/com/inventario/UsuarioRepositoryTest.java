package com.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.inventario.entity.Rol;
import com.inventario.entity.Usuario;
import com.inventario.repository.IUsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
	
	@Autowired
	private  IUsuarioRepository reposi;
	
	@Autowired
	private TestEntityManager EntityManager;
	
	@Test
	public void crearRol() {
		Rol rolAdmin=new  Rol("Administrador");
		Rol rolEditor=new  Rol("Editor");
		Rol rolVisitante=new  Rol("Visitante");
		EntityManager.persist(rolAdmin);
		EntityManager.persist(rolEditor);
		EntityManager.persist(rolVisitante);

	}
	
	@Test
	public void crearUsuarioRol() {
		Rol rolAdmin = EntityManager.find(Rol.class, 1);
		Usuario usu= new Usuario("edgar@hotmail.com","123456");
		usu.anadirRol(rolAdmin);
		reposi.save(usu);
		
	}
	
	@Test
	public void crearUsuario2Roles() {
		Rol rolVisitante = EntityManager.find(Rol.class, 3);
		Rol rolEditor = EntityManager.find(Rol.class, 2);
		Usuario usu= new Usuario("jose@hotmail.com","1234566");
		usu.anadirRol(rolVisitante);
		usu.anadirRol(rolEditor);
		reposi.save(usu);
		
	}
	
	@Test
	public void asignarRolAusuario() {
		Usuario usu= reposi.findById((long) 1).get();
		Rol rolEditor= EntityManager.find(Rol.class, 2);
		
		usu.anadirRol(rolEditor);
		
		reposi.save(usu);
		
	}
	
	@Test
	public void eliminarRol() {
		Usuario usu= reposi.findById((long) 1).get();
		Rol rol= new Rol((long)2);//rol a eliminar
		usu.eliminarRol(rol);
	}
	
	 @Test
	public void crearRolyUsuario() {
		Rol rolVendedor= new Rol("Vendedor");
		Usuario usu= new Usuario("Paul@Gmail.com","789456");
		
		usu.anadirRol(rolVendedor);
		reposi.save(usu);
	}
	 
	 @Test
	 public void obtenerUsuario() {
		 Usuario usu= reposi.findById((long)1).get();
		 EntityManager.detach(usu);
		 
		 System.out.println(usu.getEmail());
		 System.out.println(usu.getRoles());
		 
	 }
	
	 @Test
	 public void eliminarUsuario() {
		 reposi.deleteById((long)2);
	 }

}
