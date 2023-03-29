package service;

import java.util.ArrayList;
import java.util.OptionalDouble;

public class NotasService {
	//atributo donde guardamos las notas
	ArrayList<Double> notas=new ArrayList<Double>();
	//métodos de la clase
	public void guardarNota(double nota) {
		notas.add(nota);
	}
	//***
	/*public double media() {
		return notas.stream()
		.mapToDouble(d->d) //DoubleStream
		.average()
		.orElse(-1);
		
	}*/
	
	public OptionalDouble media() {
		return notas.stream()
			.mapToDouble(d->d) //DoubleStream
			.average();
	}
	//***
	public int aprobados() {
		return (int)notas.stream()
				.filter(n->n>=5)
				.count();
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
		//usando el método sort de las listas, NO el de Collections
		//notas.sort((a,b)->a>b?1:-1);
		notas.sort((a,b)->a.compareTo(b));
	}
	
	//***
	public OptionalDouble notaMayor() {
		return notas.stream()
				.mapToDouble(d->d)
				.max();
	}
	//***
	public OptionalDouble notaMenor() {
		return notas.stream()
				.mapToDouble(d->d)
				.min();
	}
}
