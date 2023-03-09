package principal;

import java.util.Scanner;

/**
 * Realiza un programa que dada una nota almacenada en una variable nos diga si
 * es un suspenso (1 a 4), aprobado (5 o 6), notable (7 u 8) o sobresaliente (9
 * o 10). Para cualquier otro valor indicará no válida
 * 
 * //realizar un programa que solicite por teclado la introducción de cinco
 * notas //que serán guardadas en un array. Las notas leídas, deben estar entre
 * 1 y 10, si introduce //un valor que no esté en ese rango, se escribirá un
 * mensaje y se volverá a leer esa nota
 * 
 * @author joseg
 *
 */
public class Notas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int notas[] = new int[5];

		for (int i = 0; i < notas.length; i++) {

			System.out.println("Introduce la nota "+(i+1)+" : ");
			int nota = sc.nextInt();
			notas[i] = nota;
			switch (nota) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println("Suspenso");
				break;
			case 5:
			case 6:
				System.out.println("Aprobado");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
			case 10:
				System.out.println("Sobresaliente");
				break;
			default:
				System.out.println("Nota no válida");
			}
		}

	}

}
