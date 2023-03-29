package com.sicpa.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formacion {
	//@JsonAlias(value="denominacion") evaluado en la deserializacion
	@JsonProperty(value="denominacion") //evaluado en la serialización/deserialización
	private String nombre;
	private int duracion;
	private String tematica;
	private int asignaturas;
}
