package com.carro.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.entity.Carro;
import com.carro.service.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepo;
	
	public List<Carro> getAll(){
		return carroRepo.findAll();
	}
	
	public Carro getCarroById(Long id) {
		return carroRepo.findById(id).orElse(null);
		
	}
	
	public Carro save(Carro carro) {
		Carro nuevoCarro= carroRepo.save(carro);
		return nuevoCarro;
		
	}
	
	public List<Carro> byUsuarioId(Long usuarioId){
		return carroRepo.findByUsuarioId(usuarioId);
		
	}
}
