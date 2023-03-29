package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;





public class NotasService {
	//atributo donde guardamos las notas
	ArrayList<Double> notas=new ArrayList<Double>();
	
	FileOutputStream fo=null;
	PrintStream out=null;
	String ruta="prueba.txt";
	
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
		
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){

			return 
			(Double[]) bf.lines()
			.collect(Collectors.toList())
			.toArray();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return null;
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
