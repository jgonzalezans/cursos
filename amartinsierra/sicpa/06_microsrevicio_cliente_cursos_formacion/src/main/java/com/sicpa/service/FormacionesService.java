package com.sicpa.service;

import java.util.List;

import com.sicpa.model.Formacion;

public interface FormacionesService {
	List<Formacion> formacionesTematica(String tematica);
	List<Formacion> nuevaFormacion(Formacion formacion);
	boolean actualizarFormacion(Formacion formacion);
	int formacionesDuracionMaxima(int duracion);
	
}
