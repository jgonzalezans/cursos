package model;

import java.time.LocalDate;

public class Item {

	String nombre;
	int casosAcumulados;
	double incidencia;
	LocalDate fecha;

	public Item(String nombre, int casosAcumulados, double incidencia, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.casosAcumulados = casosAcumulados;
		this.incidencia = incidencia;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCasosAcumulados() {
		return casosAcumulados;
	}

	public void setCasosAcumulados(int casosAcumulados) {
		this.casosAcumulados = casosAcumulados;
	}

	public double getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
