package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Alumno {

	private String dni;
	private String nombre;
	private int edad;
	private String email;
	private int curso;

}
