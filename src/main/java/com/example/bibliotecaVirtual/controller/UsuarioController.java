package com.example.bibliotecaVirtual.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaVirtual.model.Usuario;
import com.example.bibliotecaVirtual.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<?> consultarUsuarios(){
		return ResponseEntity.ok(usuarioService.consultarUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarUsuarioPorId (@PathVariable String id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario (@RequestBody Usuario usuarioDetalle, @PathVariable String id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(usuarioDetalle, usuario.get());
		usuario.get().setNombreUsuario(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.actualizarUsuario(usuario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario (@PathVariable String id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.eliminarUsuario(id);
		return ResponseEntity.ok().build();	}
}
