package com.example.bibliotecaVirtual.Services;

import java.util.Optional;
import java.util.List;

import com.example.bibliotecaVirtual.model.Libro;

public interface LibroServices {
	
	public Optional<Libro> buscarLibro(Long id, String autor, String editorial, String tipo);
	
	public List<Libro> buscarTodos();
	
	public Libro crearLibro(Libro libro);
	
	public Libro actualizarLibro(Libro libro);
	
	public String eliminarLibro(Long id);
	

}



















