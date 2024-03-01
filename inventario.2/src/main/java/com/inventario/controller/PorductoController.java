package com.inventario.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.entity.Categoria;
import com.inventario.entity.Productos;
import com.inventario.repository.ICategoria;
import com.inventario.repository.ProductoRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PorductoController {
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired ICategoria categoriaRepo;
	
	@GetMapping("/producto/nuevo")
	public String nuevoProducto(Model model) {
		List<Categoria> listaCategoria = categoriaRepo.findAll();
		
		model.addAttribute("producto", new Productos());
		model.addAttribute("listaCategoria", listaCategoria);
		return "producto_formulario";
	}
	
	@PostMapping("/producto/guardar")
	public String guardarProducto(Productos producto, HttpServletRequest request) {
		String [] detallesID= request.getParameterValues("detallesID");
		String [] detallesNombres= request.getParameterValues("detallesNombres");
		String [] detallesValores= request.getParameterValues("detallesValores");
		
		for (int  i = 0; i<detallesNombres.length; i++) {
			
			if(detallesID != null && detallesID.length>0) {
				producto.setDetalle(Long.valueOf(detallesID[i]),detallesNombres[i],detallesValores[i]);
			}else {
				producto.añadirDetalle(detallesNombres[i],detallesValores[i]);
			}
			
			
		}
		
		repository.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/productos")
	public String listarProductos(Model model) {
		List<Productos> listarProducto= repository.findAll();
		model.addAttribute("listarProducto", listarProducto);
		return "productos";
	}
	@GetMapping("/productos/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		Productos producto= repository.findById(id).get();
		
		List<Categoria> listaCategoria= categoriaRepo.findAll();
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategoria",listaCategoria);
		return "producto_formulario";
	}
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id")Long id,Model model) {
		repository.deleteById(id);
		return "redirect:/productos";
	}

}
