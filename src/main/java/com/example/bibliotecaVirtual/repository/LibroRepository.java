package com.example.bibliotecaVirtual.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.bibliotecaVirtual.model.Libro;

@Repository
public interface LibroRepository extends MongoRepository <Libro, Long> {
	
	@Query("{id: ?0, titulo: '?1', autor: '?2', editorial: '?3', tipo: '?4'}")
	public List<Libro> findByAllNotAnyo(Long id, String titulo, String autor, String editorial, String tipo);
	
	@Query("{id: ?0}")
	public Optional<Libro> findById(Long id);
	
	@Query("{titulo: '?0'}")
	public Optional<Libro> findByTitulo(String titulo);
	
	@Query("{autor: '?0'}")
	public Optional<Libro> findByAutor(String autor);
	
	@Query("{editorial: '?0'}")
	public List<Libro> findByEditorial(String editorial);
	
	@Query("{tipo: '?0'}")
	public List<Libro> findByTipo(String tipo);
}
