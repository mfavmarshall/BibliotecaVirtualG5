package com.example.bibliotecaVirtual.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaVirtual.model.Usuario;

@Repository
public interface AuthRepository extends MongoRepository<Usuario, String>{
	@Query("{nombreUsuario:'?0', contrasenaUsuario:'?1'}")
	public Optional<Usuario> autenticacion (String nombreUsuario, String contrasenaUsuario);
}
