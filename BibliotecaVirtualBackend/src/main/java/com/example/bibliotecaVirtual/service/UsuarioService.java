package com.example.bibliotecaVirtual.service;

import java.util.List;
import java.util.Optional;

import com.example.bibliotecaVirtual.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuarios();
	public Optional<Usuario> consultarUsuarioPorId(String id);
	public Usuario crearUsuario(Usuario usuario);
	public Usuario actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(String id);
}
