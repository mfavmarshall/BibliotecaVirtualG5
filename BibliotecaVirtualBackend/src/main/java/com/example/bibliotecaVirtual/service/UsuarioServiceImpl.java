package com.example.bibliotecaVirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaVirtual.model.Usuario;
import com.example.bibliotecaVirtual.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> consultarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> consultarUsuarioPorId(String id) {
		if(id == null) {
			return null;
		}else {
			return usuarioRepository.findById(id);
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.insert(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(String id) {
		usuarioRepository.deleteById(id);
	}

}
