package com.example.bibliotecaVirtual.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaVirtual.model.Libro;


@Repository
public interface LibroRepository extends MongoRepository <Libro, Long> {

	@Query("{titulo:'?0'}")
	public List<Libro> consultarPorTitulo(String titulo);

	@Query("{autor:'?0'}")
	public List<Libro> consultarPorAutor(String autor);
	
	@Query("{editorial:'?0'}")
	public List<Libro> consultarPorEditorial(String editorial);
	
	@Query("{fechaPublicacion:'?0'}")
	public List<Libro> consultarPorFechaPublicacion(String fechaPublicacion);
	
	@Query("{tipo:'?0'}")
	public List<Libro> consultarPorTipo(String tipo);
	
}
