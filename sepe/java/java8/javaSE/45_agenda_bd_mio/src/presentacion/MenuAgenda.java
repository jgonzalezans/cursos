package presentacion;

import java.util.Scanner;

import service.AgendaService;

public class MenuAgenda {
	static AgendaService service=new AgendaService();
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
					agregarContacto();
					break;
				case 2:
					eliminarContacto();
					break;
					
			}
		}while(opcion!=3);
	}
	
	static void agregarContacto() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce nombre: ");
		String nombre=sc.nextLine();
		System.out.println("Introduce email: ");
		String email=sc.nextLine();
		System.out.println("Introduce teléfono: ");
		int numero=Integer.parseInt(sc.nextLine());
		service.agregarContacto(nombre, email, numero);
	}
	static void eliminarContacto() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce email: ");
		String email=sc.nextLine();
		service.eliminarContacto(email);
	}
	
	static void mostrarMenu() {
		System.out.println("1. Añadir contacto");
		System.out.println("2. Eliminar contacto");
		System.out.println("3. Mostrar contactos");
		System.out.println("4. Salir");
	}
	
}
