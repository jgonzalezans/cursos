package model;

public class Alumno {
	//atributos
	private String nombre;
	private String dni;
	private int edad;
	//constructores: inicializar atributos al crear el objeto
	public Alumno(String nombre, String dni, int edad) {
		this.nombre=nombre;
		this.dni=dni;
		this.edad=edad;
	}
	
	//metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
