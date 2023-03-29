package presentacion;

import java.util.Scanner;

import service.AgendaService;

public class MenuAgenda {
	static AgendaService service= new AgendaService();
	public static void main(String[] args) {
		var sc=new Scanner(System.in);
		int opcion;
		do {

			mostrarMenu();

			opcion=sc.nextInt();

			switch (opcion) {
			case 1:
				agregarContacto();
				break;
			case 2:
				eliminarContacto();
				break;
			case 3:
				buscarContacto();
				break;
			case 4:
				mostrarTodos();
				break;
			}

		} while (opcion!=5);
	}

	static void agregarContacto() { // 1. A�adir contacto
		var sc=new Scanner(System.in);
		System.out.println("Introduce tel�fono: ");
		//leemos el n�mero de telefono como texto para evitar el problema de Scanner
		//ese texto se convierte a n�mero a trav�s de Integer.parseInt
		int telefono=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce nombre: ");
		String nombre=sc.nextLine();
		if(service.agregarContacto(telefono,nombre)) {
			System.out.println("Contacto a�adido!");
		}else {
			System.out.println("N�mero de tel�fono repetido, el contacto no se a�adi�");
		}
	}
	static void eliminarContacto() { // 2. Eliminar contacto
		var sc=new Scanner(System.in);
		System.out.println("Introduce tel�fono: ");
		int telefono=sc.nextInt();
		service.buscar(telefono);
	}
	static void buscarContacto() {
		var sc=new Scanner(System.in);
		System.out.println("Introduce tel�fono: ");
		int telefono=sc.nextInt();
		String nombre=service.buscar(telefono);
		if(nombre!=null) {
			System.out.println("El contacto se llama: "+nombre);
		}else {
			System.out.println("El contacto NO est� en la agenda");
		}
	}
	static void mostrarTodos() {
		var nombres=service.recuperarTodos();
		for (var nombre:nombres) {
			System.out.print(nombre+", ");
		}
		System.out.println("");
	}
	static void mostrarMenu() {
		System.out.println("1.- Introducir nuevo contacto ");
		System.out.println("2.- Introducir contacto para eliminar");
		System.out.println("3.- Introducir nombre para buscar en Agenda");
		System.out.println("4.- Mostrar todos los contactos");
		System.out.println("5.- Salir");
	}

}
