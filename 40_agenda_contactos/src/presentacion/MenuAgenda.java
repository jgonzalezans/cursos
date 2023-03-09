package presentacion;

import java.util.Scanner;

import service.ContactosService;

public class MenuAgenda {

	static ContactosService contactosService = new ContactosService();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				añadir();
				break;
			case 2:
				eliminar();
				break;
			case 3:
				buscar();
				break;
			case 4:
				mostrar();
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void mostrarMenu() {
		System.out.println("1. Añadir contacto");
		System.out.println("2. Eliminar contacto");
		System.out.println("3. Buscar contacto");
		System.out.println("4. Mostrar contactos");
		System.out.println("0. Salir");
	}

	private static void añadir() {
		System.out.println("\nIntroduce un contacto: \n");
		Scanner sc = new Scanner(System.in);
		contactosService.add(sc.nextLine().trim());
		System.out.println("\nContacto añadido! \n");
		// FIXME: Si añades el close aquí da un NoSuchElementException.
		// sc.close();
	}

	private static void eliminar() {
		System.out.println("\nIntroduce el contacto a eliminar: \n");
		Scanner sc = new Scanner(System.in);
		boolean eliminado = contactosService.delete(sc.nextLine().trim());
		if (eliminado)
			System.out.println("\nContacto eliminado\n");
		else
			System.out.println("\nContacto no encontrado\n");
	}

	private static void buscar() {
		System.out.println("\nIntroduce el contacto a buscar: \n");
		Scanner sc = new Scanner(System.in);
		String contacto = sc.nextLine().trim();
		if(contactosService.exist(contacto)) {
			System.out.println("\nContacto encontrado\n");
		}
		else {
			System.out.println("\nContacto no encontrado\n");
		}
		
		contacto = contactosService.getByName(sc.nextLine().trim());
		if (contacto != null) {
			System.out.println("\nContacto encontrado\n");
		} else {
			System.out.println("\nContacto no encontrado\n");
		}
	}

	private static void mostrar() {
		System.out.println("\nEstos son todos los contactos que hay\n");
		String contactos[] = contactosService.getAll();
		for (String contacto : contactos) {
			System.out.println(contacto);
			System.out.println("");
		}
	}
}
