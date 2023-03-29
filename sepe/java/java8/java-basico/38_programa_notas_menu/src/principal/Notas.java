package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Notas {

	public static void main(String[] args) {		
		ArrayList<Double> notas=new ArrayList<Double>();
		Scanner sc=new Scanner(System.in);
		int opcion;
		//sacar menú, evaluar la opción, procesarla y si es distinto de salir, volver
		//a scar el menú
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					pedirNota(notas);
					break;
				case 2:
					System.out.println("Nota media: "+media(notas));
					break;
				case 3:
					System.out.println("Aprobados: "+aprobados(notas));
					break;
				case 4:
					verNotas(notas);
					break;
					
			}
		}while(opcion!=5);
	}
	
	static void pedirNota(ArrayList<Double> notas) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce nota: ");
		double nota=sc.nextDouble();
		notas.add(nota);
	}
	
	static double media(ArrayList<Double> notas) {
		double media=0;
		for(double nota:notas) {
			media+=nota;
		}
		return media/notas.size();
	}
	static void mostrarMenu() {
		System.out.println("1. Añadir nota");
		System.out.println("2. Calcular media");
		System.out.println("3. Salir");
	}
	static double aprobados(ArrayList<Double> notas) {
		int contador=0;
		for(double nota:notas) {
			if(nota>=5) {
				contador++;
			}
		}
		return contador;
	}
	static void verNotas(ArrayList<Double> notas) {
		for(double nota:notas) {
			System.out.print(nota+" ");
		}
		System.out.println("");
	}

}
