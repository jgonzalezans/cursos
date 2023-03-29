package model;

public class Contacto {
	private String nombre;
	private int telefono;
	private int edad;
	
	public Contacto(String nombre, int telefono, int edad) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.edad = edad;
	}
	public Contacto() {
		
	}
	public Contacto(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
