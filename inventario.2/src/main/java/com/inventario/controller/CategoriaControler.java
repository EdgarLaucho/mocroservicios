package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.entity.Categoria;
import com.inventario.repository.ICategoria;


@Controller
public class CategoriaControler {

	@Autowired
	private ICategoria repository;
	
	@GetMapping("/categoria")
	public String ListaCategoria(Model model) {
		List<Categoria> listaCategoria = repository.findAll();
		model.addAttribute("listaCategoria",listaCategoria);
		return "categorias";
	}
	
	@GetMapping("/categoria/nuevo")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoria_formulario";
	}
	@PostMapping("/categoria/guardar")
	public String guardarCategoria(Categoria categoria) {
		repository.save(categoria);
		return "redirect:/categoria";
		
	}
}
