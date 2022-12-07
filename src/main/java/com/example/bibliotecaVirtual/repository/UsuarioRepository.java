package com.example.bibliotecaVirtual.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.bibliotecaVirtual.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
}
