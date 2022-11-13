package com.example.bibliotecaVirtual.Services;

import java.util.List;
import java.util.Optional;

import com.example.bibliotecaVirtual.model.Libro;

public class LibroServicesImpl implements LibroServices {

	@Override
	public Optional<Libro> buscarLibroNoAnyo(Long id, String titulo, String autor, String editorial, String tipo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Libro> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Libro> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Libro> buscarPorAutor(String autor) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Libro> buscarPorEditorial(String editorial) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Libro> buscarPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Libro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro crearLibro(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro actualizarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarLibro(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
