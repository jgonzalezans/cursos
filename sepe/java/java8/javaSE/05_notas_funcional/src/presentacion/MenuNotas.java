package presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import service.NotasService;

public class MenuNotas {
	static NotasService service=new NotasService();
	public static void main(String[] args) {		
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		//sacar menú, evaluar la opción, procesarla y si es distinto de salir, volver
		//a scar el menú
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					pedirNota();
					break;
				case 2:
					media();
					break;
				case 3:
					aprobados();
					break;
				case 4:
					subirNotas();
					break;
				case 5:
					eliminarSuspensos();
					break;
				case 6:
					verNotas();
					break;
				case 7:
					notaMayor();
					break;
				case 8:
					notaMenor();
					break;
					
			}
		}while(opcion!=0);
	}
	
	static void pedirNota() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce nota: ");
		double nota=sc.nextDouble();
		service.guardarNota(nota);
	}
	static void subirNotas() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce incremento: ");
		double incremento=sc.nextDouble();
		service.subirNotas(incremento);
	}
	static void eliminarSuspensos() {
		service.eliminarSuspensos();
	}
	
	static void media() {
		System.out.println("Nota media: "+service.media());
	}
	static void mostrarMenu() {
		System.out.println("1. Añadir nota");
		System.out.println("2. Calcular media");
		System.out.println("3. Calcular aprobados");
		System.out.println("4. Subir notas");
		System.out.println("5. Eliminar suspensos");
		System.out.println("6. Mostrar notas");
		System.out.println("7. Mostrar nota mayor");
		System.out.println("8. Mostrar nota menor");
		System.out.println("0. Salir");
	}
	static void aprobados() {
		System.out.println("Aprobados: "+service.aprobados());
	}
	static void verNotas() {
		Double[] notas=service.devolverNotas();
		for(double n:notas) {
			System.out.print(n+" ");
		}
		System.out.println("");
	}
	static void notaMayor() {
		System.out.println("La nota mayor es: "+service.notaMayor().get());
	}
	static void notaMenor() {
		System.out.println("La nota menor es: "+service.notaMenor().get());
	}

}
