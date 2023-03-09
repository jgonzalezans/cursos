package presentacion;

import java.util.Scanner;

import service.NotasService;

public class MenuNotas {
	static NotasService service = new NotasService();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		// sacar menú, evaluar la opción, procesarla y si es distinto de salir, volver
		// a scar el menú
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
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
				verNotas();
				break;

			}
		} while (opcion != 5);
	}

	static void pedirNota() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nota: ");
		double nota = sc.nextDouble();
		service.guardarNota(nota);
	}

	static void media() {
		System.out.println("Nota media: " + service.media());
	}

	static void mostrarMenu() {
		System.out.println("1. Añadir nota");
		System.out.println("2. Calcular media");
		System.out.println("3. Calcular aprobados");
		System.out.println("4. Mostrar notas");
		System.out.println("5. Salir");
	}

	static void aprobados() {
		System.out.println("Aprobados: " + service.aprobados());
	}

	static void verNotas() {
		double[] notas = service.devolverNotas();
		for (double n : notas) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
