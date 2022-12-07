package com.example.bibliotecaVirtual.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaVirtual.model.Usuario;
import com.example.bibliotecaVirtual.service.AuthService;

@RestController
@RequestMapping("/api/token")
public class AuthController {
	
	@Autowired
	private AuthService servicio;
	
	@PostMapping
	public ResponseEntity<?> login (@RequestBody Usuario usuario) {
		String respuesta = servicio.autenticacion(usuario);
		if(respuesta == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return ResponseEntity.ok().body(new JSONObject().put("token", respuesta).toString());
		}
	}

}
