package com.example.bibliotecaVirtual.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Libro {
	@Id
	private Long id;
	private String titulo;
	private String autor;
	private String editorial;
	private Date fechaPublicacion;
	private String tipo;
	
	public Libro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, editorial, fechaPublicacion, id, tipo, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(editorial, other.editorial)
				&& Objects.equals(fechaPublicacion, other.fechaPublicacion) && Objects.equals(id, other.id)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", fechaPublicacion=" + fechaPublicacion + ", tipo=" + tipo + "]";
	}
	
	
	
}
