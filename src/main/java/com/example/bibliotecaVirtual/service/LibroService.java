package com.example.bibliotecaVirtual.service;

import java.util.List;
import java.util.Optional;

import com.example.bibliotecaVirtual.model.Libro;

public interface LibroService {
	public List<Libro> consultarTodos();
	public Optional<Libro> consultarPorId(Long id);
	public List<Libro> consultarPorTitulo(String titulo);
	public List<Libro> consultarPorAutor(String autor);
	public List<Libro> consultarPorEditorial(String editorial);
	public List<Libro> consultarPorFechaPublicacion(String fechaPublicacion);
	public List<Libro> consultarPorTipo(String tipo);
	public Libro crearLibro(Libro libro);
	public Libro actualizarLibro (Libro libro);
	public void eliminarLibro (Long id);
}
