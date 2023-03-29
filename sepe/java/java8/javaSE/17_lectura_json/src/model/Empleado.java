package model;

public class Empleado {
	private String nombre;
	private String email;
	private double salario;
	private String departamento;
	public Empleado(String nombre, String email, double salario, String departamento) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.salario = salario;
		this.departamento = departamento;
	}
	public Empleado() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
