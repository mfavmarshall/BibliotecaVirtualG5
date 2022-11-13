package com.example.bibliotecaVirtual.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaVirtual.model.Libro;

@Repository
public interface LibroRepository extends MongoRepository <Libro, Long> {

}
