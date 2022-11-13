package com.example.bibliotecaVirtual.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
	private Long idUsuario;
	private String nombreUsuario;
	private String correoUsuario;
	private String contraseñaUsuario;
	
	public Usuario() {
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}

	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseñaUsuario, correoUsuario, idUsuario, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contraseñaUsuario, other.contraseñaUsuario)
				&& Objects.equals(correoUsuario, other.correoUsuario) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(nombreUsuario, other.nombreUsuario);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", correoUsuario="
				+ correoUsuario + ", contraseñaUsuario=" + contraseñaUsuario + "]";
	}

	
	
}
