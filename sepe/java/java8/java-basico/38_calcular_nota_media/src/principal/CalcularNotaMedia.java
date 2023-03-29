package principal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Nueva versión del programa de notas:
 * Cuando se inicie el programa, aparecerá el siguiente menú:
 * 1.- Introducir nota
 * 2.- Mostrar nota media
 * 3.- Salir
 * al elegir la opcion 1, se pide la nota y se guarda, después, vuelve a salir el menu.
 * Si elige la opción 2, se muestra la nota media de las que llevamos guardadas hasta el momento,
 * y vuelve a salir el menú
 * si se elige la opción 3, el programa termina
 * 
 * @author joseg
 *
 */
public class CalcularNotaMedia {

	public static void main(String[] args) {

		int opcion = 0;

		ArrayList<Double> notas = new ArrayList<>();

		while (opcion != 3) {

			opcion = eligeOpcion();

			switch (opcion) {
			case 1:

				introducirNota(notas);
				mostrarNotas(notas);
				break;
			case 2:

				mostrarNotaMedia(notas);
				break;
			case 3:

				System.out.println("Has salido del programa");
				break;

			default:
				break;
			}

		}

	}

	private static void mostrarNotas(ArrayList<Double> notas) {

		System.out.println("Estas son las notas que hay: ");
		
		for (Double nota : notas) {
			
			System.out.println(" "+nota);
		}
	}

	private static void mostrarNotaMedia(ArrayList<Double> notas) {

		double media = 0.0;

		for (Double nota : notas) {

			media += nota;
		}

		media = media / notas.size();

		System.out.println("La media de notas es " + media);

	}

	private static void introducirNota(ArrayList<Double> notas) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la nota");
		
		notas.add(sc.nextDouble());
	}

	private static int eligeOpcion() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la opción 1 , 2 o 3");

		return sc.nextInt();
	}

}
