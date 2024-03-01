package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.entity.Rol;
import com.inventario.entity.Usuario;
import com.inventario.repository.IRolRepository;
import com.inventario.repository.IUsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository usuReposi;
	
	@Autowired
	private IRolRepository rolReposi;

	@GetMapping("/usuario")
	public String listaUsuario(Model model) {
		List<Usuario> listaUsuario= usuReposi.findAll();
		model.addAttribute("listaUsuario", listaUsuario);
	
		return "usuario";
	}
	
	@GetMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model) {
		List<Rol> listaRoles= rolReposi.findAll();
		model.addAttribute("listaRoles", listaRoles);
		model.addAttribute("usuario", new Usuario());
		return "usuario_formulario";
	}
	@PostMapping("/usuario/guardar")
	public String guardarUsuario(Usuario usuario) {
		usuReposi.save(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("/usuario/editar/{id}")
	public String editarUsuario(@PathVariable("id") Long id,Model model) {
		Usuario usuario= usuReposi.findById(id).get();
		model.addAttribute("usuario", usuario);
		
		List<Rol> listaRoles= rolReposi.findAll();
		model.addAttribute("listaRoles", listaRoles);
		return "usuario_formulario";
	}
	
	 @GetMapping("usuario/eliminar/{id}")
	 public String eliminarUsuario(@PathVariable("id") Long id) {
		 usuReposi.deleteById(id);
		 return "redirect:/usuario";
	 }
	
}
