package com.example.bibliotecaVirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaVirtual.model.Libro;
import com.example.bibliotecaVirtual.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> consultarTodos() {
		return libroRepository.findAll();
	}

	@Override
	public Optional<Libro> consultarPorId(Long id) {
		return libroRepository.findById(id);
	}

	@Override
	public List<Libro> consultarPorTitulo(String titulo) {
		return libroRepository.consultarPorTitulo(titulo);
	}

	@Override
	public List<Libro> consultarPorAutor(String autor) {
		return libroRepository.consultarPorAutor(autor);
	}

	@Override
	public List<Libro> consultarPorEditorial(String editorial) {
		return libroRepository.consultarPorEditorial(editorial);
	}

	@Override
	public List<Libro> consultarPorFechaPublicacion(String fechaPublicacion) {
		return libroRepository.consultarPorFechaPublicacion(fechaPublicacion);
	}

	@Override
	public List<Libro> consultarPorTipo(String tipo) {
		return libroRepository.consultarPorTipo(tipo);
	}

	@Override
	public Libro crearLibro(Libro libro) {
		if (libro == null) {
			return null;
		}

		if (libro.getId() == null) {
			return null;
		}

		Optional<Libro> libroExistente = libroRepository.findById(libro.getId());
		if (libroExistente.isPresent()) {
			return libroExistente.get();
		} else {
			return libroRepository.insert(libro);
		}
	}

	@Override
	public Libro actualizarLibro(Libro libro) {
		if (libro == null) {
			return null;
		}
		if (libro.getId() == null) {
			return null;
		}
		Optional<Libro> libroExistente = libroRepository.findById(libro.getId());
		if (libroExistente.isPresent()) {
			return libroRepository.save(libro);
		} else {
			return null;
		}
	}

	@Override
	public void eliminarLibro(Long id) {
		Optional<Libro> libroExistente = libroRepository.findById(id);
		if (libroExistente.isPresent()) {
			libroRepository.delete(libroExistente.get());
		}
	}
}
