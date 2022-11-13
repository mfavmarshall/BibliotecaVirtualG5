package com.example.bibliotecaVirtual.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bibliotecaVirtual.model.Libro;
import com.example.bibliotecaVirtual.repository.LibroRepository;

public class LibroServicesImpl implements LibroServices {

	@Autowired
	LibroRepository repository;
	
	@Override
	public Optional<Libro> buscarLibroNoAnyo(Long id, String titulo, String autor, String editorial, String tipo) {
		if(id == null && titulo == null && autor == null && editorial == null && tipo == null) {
			return Optional.empty();
		}
		if(id == null) {
			List<Libro> libros = repository.findByTitulo(titulo);
			if(libros.isEmpty()) {
				return Optional.empty();
			}else {
				return Optional.of(libros.get(0));
			}
		}
		if(titulo == null) {
			return repository.findByAutor(autor);
		}
		List<Libro> librosFiltrados = repository.findByAllNotAnyo(id, titulo, autor, editorial, tipo);
		if(librosFiltrados.isEmpty()) {
			return Optional.empty();
		}else {
			return Optional.of(librosFiltrados.get(0));
		}
	}

	@Override
	public Optional<Libro> buscarPorId(Long id) {
		if(id == null) {
			return Optional.empty();
		}
		return repository.findById(id);
		
	}

	@Override
	public Optional<Libro> buscarPorTitulo(String titulo) {
		if(titulo == null) {
			return Optional.empty();
		}
		return repository.findByTitulo(titulo);
	}

	@Override
	public Optional<Libro> buscarPorAutor(String autor) {
		if(autor == null) {
			return Optional.empty();
		}
		return repository.findByAutor(autor);
	}

	@Override
	public Optional<Libro> buscarPorEditorial(String editorial) {
		if(editorial == null) {
			return Optional.empty();
		}
		return repository.findByEditorial(editorial);
	}

	@Override
	public Optional<Libro> buscarPorTipo(String tipo) {
		if(tipo == null) {
			return Optional.empty();
		}
		return repository.findByTipo(tipo);
	}

	@Override
	public List<Libro> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Libro crearLibro(Libro libro) {
		if(libro == null) {
			return null;
		}
		if(libro.getId() == null) {
			return null;
		}
		Optional<Libro> libroExistente = repository.findById(libro.getId());
		if(libroExistente.isPresent()) {
			return libroExistente;
		}else {
			return repository.insert(libro);
		}
	}

	@Override
	public Libro actualizarLibro(Libro libro) {
		if(libro == null) {
			return null;
		}
		if(libro.getId() == null) {
			return null;
		}
		Optional<Libro> libroExistente = repository.findById(libro.getId());
		if(libroExistente.isPresent()) {
			return repository.save(libro);
		}else {
			return null;
		}
	}

	@Override
	public String eliminarLibro(Long id) {
		if(id == null) {
			return  "El código no puede ser ejecutado;
		}
		Optional<Libro> libroExistente = repository.findById(id);
		if(libroExistente.isPresent()) {
			repository.delete(libroExistente.get());
			return "El Libro ha sido eliminado";
		}
		return "El pais no pudo ser eliminado"
	}

}
