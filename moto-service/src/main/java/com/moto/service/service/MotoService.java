package com.moto.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoService {
	
	@Autowired
	private MotoRepository motoRepo;
	
	public List<Moto> listarmoto(){
		return motoRepo.findAll();
	}
	
	public Moto getMotoById(Long id) {
		return motoRepo.findById(id).orElse(null);
	}

	public Moto save(Moto moto) {
		Moto nuevaMoto= motoRepo.save(moto);
		return nuevaMoto;
	}
	
	public List<Moto> byMotoUsuarioId(Long id){
		return motoRepo.findByUsuarioId(id);
	}
}
