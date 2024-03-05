package com.usuario.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//habilitar el cliente feign podrmos llamar a los demas microservicios
@EnableFeignClients
@SpringBootApplication

public class UsuarioService1Application {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioService1Application.class, args);
	}

}
