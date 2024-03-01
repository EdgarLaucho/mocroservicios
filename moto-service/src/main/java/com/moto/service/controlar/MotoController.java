package com.moto.service.controlar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entity.Moto;
import com.moto.service.service.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {
	
	@Autowired
	private MotoService motoSer;
	
	@GetMapping
	public ResponseEntity<List<Moto>> listaMoto(){
		List<Moto> motos= motoSer.listarmoto();
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		} else {
			return ResponseEntity.ok(motos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id")Long id){
		Moto moto = motoSer.getMotoById(id);
		if (moto==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(moto);
		}
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
		Moto nuevaMoto = motoSer.save(moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotoByUsarioId(@PathVariable("usuarioId") Long usuarioId){
		List<Moto> motos= motoSer.byMotoUsuarioId(usuarioId);
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(motos);

		}
	}

}
