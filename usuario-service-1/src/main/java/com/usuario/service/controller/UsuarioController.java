package com.usuario.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entity.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.service.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServicio usuSer;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarusuario(){
		List<Usuario> usuarios= usuSer.getAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();	
		} else {
			return ResponseEntity.ok(usuarios);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id){
		Usuario usuario= usuSer.getUsuarioById(id);
		if (usuario ==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(usuario);
		}
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		Usuario nuevoUsuario= usuSer.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarro(@PathVariable("usuarioId") Long id){
	    Usuario usuario= usuSer.getUsuarioById(id);
	    if (usuario==null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        List<Carro> carros= usuSer.getCarro(id);
	        return ResponseEntity.ok(carros);
	    }
	}
	
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMoto(@PathVariable("usuarioId") Long id){
		Usuario usuario= usuSer.getUsuarioById(id);
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		} else {
			List<Moto> motos= usuSer.getMoto(id);
			return ResponseEntity.ok(motos);
		}
	}
	
	@PostMapping("/carro/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") Long usuarioId, @RequestBody Carro carro){
		Carro nuevoCarro= usuSer.saveCarro(usuarioId, carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") Long usuarioId,@RequestBody Moto moto){
		Moto nuevaMoto=usuSer.saveMoto(usuarioId, moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodo(@PathVariable("usuarioId") Long usuarioId){
		Map<String, Object> resultado= usuSer.getUsuarioVehiculos(usuarioId);
		return ResponseEntity.ok(resultado);
	}
}

