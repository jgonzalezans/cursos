package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
	private Object nombre;
	private int duracion;
	private double precio;
	private String[] asignaturas;
	private String horario;
	
}
