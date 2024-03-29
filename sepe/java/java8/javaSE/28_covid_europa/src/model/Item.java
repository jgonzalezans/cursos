package model;

import com.google.gson.annotations.SerializedName;

public class Item {
	@SerializedName(value = "country")
	private String nombrePais;
	@SerializedName(value = "continent")
	private String continente;
	@SerializedName(value = "year_week")
	private String fecha;
	@SerializedName(value = "rate_14_day")
	private double incidencia;
	@SerializedName(value = "cumulative_count")
	private int acumulados;
	@SerializedName(value = "indicator")
	private String indicador;
	
	public Item(String nombrePais, String continente, String fecha, double incidencia, int acumulados,
			String indicador) {
		super();
		this.nombrePais = nombrePais;
		this.continente = continente;
		this.fecha = fecha;
		this.incidencia = incidencia;
		this.acumulados = acumulados;
		this.indicador = indicador;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}

	public int getAcumulados() {
		return acumulados;
	}

	public void setAcumulados(int acumulados) {
		this.acumulados = acumulados;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	
	
	
	
}
