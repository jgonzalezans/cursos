package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Curso {
	
	private int idCurso;
	private String denominacion;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;

}
