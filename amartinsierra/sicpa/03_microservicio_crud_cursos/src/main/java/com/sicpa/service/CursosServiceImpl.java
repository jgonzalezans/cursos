package com.sicpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sicpa.model.Curso;

@Service
public class CursosServiceImpl {
	List<Curso> cursos;
	{
		cursos=new ArrayList<>(List.of(new Curso("Java 17",40,"programación"),
				new Curso("php",30,"web"),
				new Curso("python",60,"programación"),
				new Curso("Spring",50,"programación"),
				new Curso("Docker",30,"devops")
				));
	}
	//@Override
	public List<Curso> cursos() {
		return cursos;
	}

	//@Override
	public List<Curso> cursosCortos(int duracionMax) {
		return cursos
				.stream()
				.filter(c->c.getDuracion()<=duracionMax)
				.collect(Collectors.toList());
	}

	//@Override
	public Curso cursoDenominacion(String denominacion) {
		return cursos
				.stream()
				.filter(c->c.getDenominacion().equals(denominacion))
				.findFirst()
				.orElse(null);
	}

	//@Override
	public void eliminarCurso(String denominacion) {
		cursos.removeIf(c->c.getDenominacion().equals(denominacion));

	}

	//@Override
	public Curso altaCurso(Curso curso) {
		if(cursoDenominacion(curso.getDenominacion())==null) {
			cursos.add(curso);
			return curso;
		}
		return null;
	}

	//@Override
	public boolean actualizarCurso(Curso curso) {
		Curso cursoBuscado=cursoDenominacion(curso.getDenominacion());
		if(cursoBuscado!=null) {
			cursoBuscado.setDuracion(curso.getDuracion());
			cursoBuscado.setTematica(curso.getTematica());
			return true;
		}
		return false;
	}

}
