package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.entity.Categoria;
import com.inventario.entity.Marca;
import com.inventario.entity.Productos;
import com.inventario.repository.ICategoria;
import com.inventario.repository.IMarcaRepo;

@Controller
public class MarcaController {
	
	@Autowired
	private IMarcaRepo marcaRepo;
	
	@Autowired
	private ICategoria categoriaRepo;
	
	@GetMapping("/marca/nueva")
	public String nuevaMarca(Model model) {
		List<Categoria> listaCategoria= categoriaRepo.findAll();
		model.addAttribute("listaCategoria", listaCategoria);
		model.addAttribute("marca", new Marca());
		return "marca_formulario";
	}
	@PostMapping("/marca/guardar")
	public String guardarMarca(Marca marca) {
		marcaRepo.save(marca);
		return "redirect:/marca/listar";
		
	}
	@GetMapping("/marca/listar")
	public String listarMarca(Model model) {
		List<Marca> listaMarca=marcaRepo.findAll();
		List<Categoria> listaCategoria=categoriaRepo.findAll();
		model.addAttribute("listaMarca", listaMarca);
		model.addAttribute("listaCategoria", listaCategoria);
		return "marca";
	}
	@GetMapping("/marca/editar/{id}")
	public String editarMarca(@PathVariable("id") Long id, Model model) {
		Marca marca= marcaRepo.findById(id).get();
		
		List<Categoria> listaCategoria= categoriaRepo.findAll();
		model.addAttribute("marca", marca);
		model.addAttribute("listaCategoria",listaCategoria);
		return "marca_formulario";
	}
	@GetMapping("/marca/eliminar/{id}")
	public String borrarMarca(@PathVariable("id") Long id,Model model) {
		marcaRepo.deleteById(id);
		return "redirect:/marca/listar";
	}
}
