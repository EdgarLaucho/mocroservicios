package com.carro.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entity.Carro;
import com.carro.service.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroSer;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarros(){
		List<Carro> carros= carroSer.getAll();
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		} else {
			return ResponseEntity.ok(carros);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id")Long id){
		Carro carro= carroSer.getCarroById(id);
		if (carro==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(carro);
		}
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro nuevoCarro = carroSer.save(carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarroByUsarioId(@PathVariable("usuarioId") Long id){
		List<Carro> carros= carroSer.byUsuarioId(id);
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(carros);

		}
	}
}

