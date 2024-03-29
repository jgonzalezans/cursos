package service;

import java.util.ArrayList;

public class NotasService {
	// atributo donde guardamos las notas
	ArrayList<Double> notas = new ArrayList<Double>();

	// m�todos de la clase
	public void guardarNota(double nota) {
		notas.add(nota);
	}

	public double media() {
		double media = 0;
		for (double nota : notas) {
			media += nota;
		}
		return media / notas.size();
	}

	public int aprobados() {
		int contador = 0;
		for (double nota : notas) {
			if (nota >= 5) {
				contador++;
			}
		}
		return contador;
	}

	public double[] devolverNotas() {
		double[] valores = new double[notas.size()];
		for (int i = 0; i < notas.size(); i++) {
			valores[i] = notas.get(i);
		}
		return valores;
	}
}