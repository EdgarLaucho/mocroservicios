package com.usuario.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entity.Usuario;
import com.usuario.service.feignclients.CarroFeignClient;
import com.usuario.service.feignclients.MotoFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repository.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepository usuRepos;
	
	@Autowired
	private CarroFeignClient carroFeign;
	
	@Autowired
	private MotoFeignClient motoFeign;
	
	
	public List<Usuario> getAll(){
		return usuRepos.findAll();
	}
	
	public Usuario getUsuarioById(Long id) {
		return usuRepos.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario= usuRepos.save(usuario);
		return nuevoUsuario;
	}
	//inicio de rest-------template para conectarce a los demas microservicios
		public List<Carro> getCarro(Long usuarioId){
			List<Carro> carros= restTemplate.getForObject("http://localhost:8002/carro/usuario/"+ usuarioId, List.class);
			return carros;
		}
		
		public List<Moto> getMoto(Long usuarioId){
			List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/"+ usuarioId, List.class);
			return motos;
		}
		
		//Fin de restTemplate
		
		//Metodo Feign de consulta y conexion con los otros microservicios
		public Carro saveCarro(Long usuarioId,Carro carro) {
			carro.setUsuarioId(usuarioId);
			Carro nuevoCarro= carroFeign.save(carro);
			return nuevoCarro;
		}
		
		public Moto saveMoto(Long usuaruiId,Moto moto) {
		moto.setUsuarioId(usuaruiId);
		Moto nuevaMoto= motoFeign.save(moto);
		return nuevaMoto;
		}
		
		public Map<String, Object> getUsuarioVehiculos(Long usuarioId){
			Map<String, Object> resultado= new HashMap<>();
			Usuario usuario= usuRepos.findById(usuarioId).orElse(null);
			if (usuario==null) {
				resultado.put("Mensaje", "El usuario no existe");
				return resultado;
			} else {
				resultado.put("Usuario", usuario);
				List<Carro> carros= carroFeign.getCarro(usuarioId);
				if (carros.isEmpty()) {
					resultado.put("Carros:", "El usuario no posee carros");
				} else {
					resultado.put("Carros", carros);
				}
				List<Moto> motos= motoFeign.getMoto(usuarioId);
				if (motos.isEmpty()) {
					resultado.put("Motos", "El usuario no tienen motos");
				} else {
					resultado.put("Motos", motos);
				}
				return resultado;
			}
			
		}
		//fin de metodos
}
