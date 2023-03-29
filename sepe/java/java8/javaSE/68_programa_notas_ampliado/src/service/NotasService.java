package service;

import java.util.ArrayList;

public class NotasService {
	//atributo donde guardamos las notas
	ArrayList<Double> notas=new ArrayList<Double>();
	//m�todos de la clase
	public void guardarNota(double nota) {
		notas.add(nota);
	}
	
	public double media() {
		double media=0;
		for(double nota:notas) {
			media+=nota;
		}
		return media/notas.size();
	}
	
	public int aprobados() {
		int contador=0;
		for(double nota:notas) {
			if(nota>=5) {
				contador++;
			}
		}
		return contador;
	}
	
	public Double[] devolverNotas() {
		/*double[] valores=new double[notas.size()];
		for(int i=0;i<notas.size();i++) {
			valores[i]=notas.get(i);
		}*/
		Double[] valores=notas.toArray(new Double[0]);
		return valores;
	}
	
	public void subirNotas(double incremento) {		
		notas.replaceAll(n->n+incremento);
	}
	public void eliminarSuspensos() {
		notas.removeIf(n->n<5);
	}
	public void ordenarNotas() {
		//usando el m�todo sort de las listas, NO el de Collections
		//notas.sort((a,b)->a>b?1:-1);
		notas.sort((a,b)->a.compareTo(b));
	}
}
