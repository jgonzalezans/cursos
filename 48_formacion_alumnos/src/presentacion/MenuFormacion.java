package presentacion;

import java.util.Scanner;

import model.Alumno;
import service.AlumnosService;

public class MenuFormacion {
	static AlumnosService service= new AlumnosService();
	public static void main(String[] args) {
		var sc=new Scanner(System.in);
		int opcion;
		do {

			mostrarMenu();

			opcion=sc.nextInt();

			switch (opcion) {
			case 1:
				agregarAlumno();
				break;
			case 2:
				buscarAlumno();
				break;
			case 3:
				notaMedia();
				break;
			case 4:
				alumnoDestacado();
				break;
			}

		} while (opcion!=5);
	}

	static void agregarAlumno() { // 1. Añadir contacto
		var sc=new Scanner(System.in);
		System.out.println("Introduce dni: ");
		
		String dni=sc.nextLine();
		System.out.println("Introduce nombre: ");
		String nombre=sc.nextLine();
		System.out.println("Introduce curso: ");
		String curso=sc.nextLine();
		System.out.println("Introduce nota: ");
		double nota=Double.parseDouble(sc.nextLine());
		if(service.agregar(nombre, dni, curso, nota)) {
			System.out.println("Alumno añadido!");
		}else {
			System.out.println("Dni repetido, el alumno no se añadió");
		}
	}
	static void notaMedia() {
		System.out.println("Nota media de los alumnos: "+service.notaMedia());
	}
	static void buscarAlumno() {
		var sc=new Scanner(System.in);
		System.out.println("Introduce dni: ");
		
		String dni=sc.nextLine();
		Alumno alumno=service.buscarAlumno(dni);
		if(alumno!=null) {
			System.out.println("El alumno se llama: "+alumno.getNombre());
		}else {
			System.out.println("El alumno NO está registrado");
		}
	}
	static void alumnoDestacado() {
		Alumno alumno=service.alumnoNotaMayor();
		if(alumno==null) {
			System.out.println("No hay alumno destacado");
		}else {
			System.out.println("El alumno se llama: "+alumno.getNombre());
		}
	}
	static void mostrarMenu() {
		System.out.println("1.- Nuevo alumno ");
		System.out.println("2.- Buscar alumno");
		System.out.println("3.- Nota media global");
		System.out.println("4.- Alumno destacado");
		System.out.println("5.- Salir");
	}

}
