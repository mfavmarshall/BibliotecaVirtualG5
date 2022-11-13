package com.example.bibliotecaVirtual.controller;

import java.util.Optional;


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

import com.example.bibliotecaVirtual.model.Libro;
import com.example.bibliotecaVirtual.service.LibroService;


@RestController
@RequestMapping("/api/libros")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<?> consultarTodos(){
		return ResponseEntity.ok(libroService.consultarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id){
		return ResponseEntity.ok(libroService.consultarPorId(id));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<?> buscarPorTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(libroService.consultarPorTitulo(titulo));
		
	}
	
	@GetMapping("/autor/{autor}")
	public ResponseEntity<?> buscarPorAutor(@PathVariable String autor){
		return ResponseEntity.ok(libroService.consultarPorAutor(autor));
		
	}
	@GetMapping("/editorial/{editorial}")
	public ResponseEntity<?> buscarPorEditorial(@PathVariable String editorial){
		return ResponseEntity.ok(libroService.consultarPorEditorial(editorial));
		
	}
	@GetMapping("/fechaPublicacion/{fechaPublicacion}")
	public ResponseEntity<?> buscarPorFechaPublicacion(@PathVariable Integer fechaPublicacion){
		return ResponseEntity.ok(libroService.consultarPorFechaPublicacion(fechaPublicacion));
		
	}
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<?> buscarPorTipo(@PathVariable String tipo){
		return ResponseEntity.ok(libroService.consultarPorTipo(tipo));
		
	}
	
	@PostMapping
	public ResponseEntity<?> crearLibro (@RequestBody Libro libro){
		Libro libroExistente = libroService.crearLibro(libro);
		if(libroExistente == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El libro no se pudo crear");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(libroExistente);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarLibro (@RequestBody Libro libro){
		Libro libroExistente = libroService.actualizarLibro(libro);
		if(libroExistente == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El libro no se pudo actualizar");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(libroExistente);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarLibro(@PathVariable Long id){
		Optional<Libro> libroExistente = libroService.consultarPorId(id);
		if (!libroExistente.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
		libroService.eliminarLibro(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Libro eliminado");
	}
	
}

