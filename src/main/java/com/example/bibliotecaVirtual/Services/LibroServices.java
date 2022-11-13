package com.example.bibliotecaVirtual.Services;

import java.util.Optional;
import java.util.List;

import com.example.bibliotecaVirtual.model.Libro;

public interface LibroServices {
	
	public Optional<Libro> buscarLibroNoAnyo(Long id, String titulo, String autor, String editorial, String tipo);
	
	public Optional<Libro> buscarPorId(Long id);
	
	public Optional<Libro> buscarPorTitulo(String titulo);

	public Optional<Libro> buscarPorAutor(String autor);
	
	public Optional<Libro> buscarPorEditorial(String editorial);
	
	public Optional<Libro> buscarPorTipo(String tipo);
	
	public List<Libro> buscarTodos();
	
	public Libro crearLibro(Libro libro);
	
	public Libro actualizarLibro(Libro libro);
	
	public String eliminarLibro(Long id);
	
}