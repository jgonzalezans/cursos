package model;

/**
 * Crear una clase Cuenta, que incluya m�todos para la realizaci�n de
 * operaciones sobre una cuenta (ingreso, extracci�n y recuperaci�n de saldo),
 * operaciones que se llevar�n a cabo sobre el atributo saldo de la clase
 * 
 * @author joseg
 *
 */

public class Cuenta {

	private double saldo;

	public Cuenta(double saldo) {
		super();
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(double cantidad) {

		saldo += cantidad;
	}

	public void extraer(double cantidad) {

		saldo -= cantidad;
	}
	
}
