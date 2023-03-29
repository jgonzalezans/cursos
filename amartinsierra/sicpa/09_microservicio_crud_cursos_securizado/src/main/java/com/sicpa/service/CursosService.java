package com.sicpa.service;

import java.util.List;

import com.sicpa.model.Curso;

public interface CursosService {
	List<Curso> cursos();
	List<Curso> cursosCortos(int duracionMax);
	Curso cursoDenominacion(String denominacion);
	void eliminarCurso(String denominacion);
	Curso altaCurso(Curso curso);
	boolean actualizarCurso(Curso curso);
}
