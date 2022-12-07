package com.example.bibliotecaVirtual.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaVirtual.model.Usuario;
import com.example.bibliotecaVirtual.repository.AuthRepository;
import com.example.bibliotecaVirtual.util.JWTUtil;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	AuthRepository repositorio;

	@Override
	public String autenticacion(Usuario usuario) {
		Optional<Usuario> usuarioConsultado = repositorio.autenticacion(usuario.getNombreUsuario()
				, usuario.getContrasenaUsuario());
		if(usuarioConsultado.isPresent()) {
			String role = "user";
			if (usuario.getNombreUsuario().equals("admin")) {
				role = "admin";
			}
			return JWTUtil.getToken(usuario.getNombreUsuario(), role);
		}
		return null;
	}

}
