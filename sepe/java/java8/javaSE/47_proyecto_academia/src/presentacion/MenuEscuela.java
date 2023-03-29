package presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.Alumno;
import model.Curso;
import service.EscuelaService;

public class MenuEscuela {
	static EscuelaService service=new EscuelaService();
	static DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
					nuevoCurso();
					break;
				case 2:
					//nuevoAlumno();
					break;
				case 3:
					alumnosCurso();
					break;
				case 4:
					//cursosFecha();
					break;
				case 5:
					buscarAlumno();
					break;
					
			}
		}while(opcion!=7);

	}
	static void mostrarMenu() {
		System.out.println("1. Nuevo curso");
		//System.out.println("2. Nuevo alumno");
		System.out.println("3. Alumnos por curso");
		//System.out.println("4. Cursos por fecha");
		System.out.println("5. Buscar alumno");
		System.out.println("7. Salir");
	}
	
	static void nuevoCurso() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Denominación: ");
		String denominacion=sc.nextLine();
		System.out.println("Duración: ");
		int duracion=Integer.parseInt(sc.nextLine());
		System.out.println("Precio: ");
		double precio=Double.parseDouble(sc.nextLine());		
		System.out.println("Introduce fecha de inicio (dd/MM/yyyy): ");
		try {
			LocalDate fecha=LocalDate.parse(sc.nextLine(),format);
			
			if(service.cursoDenominacion(denominacion)!=null) {
				System.out.println("Ese curso está repetido");
				return;
			}
			if(service.altaCurso(new Curso(0,denominacion,duracion,precio,fecha))) {
				System.out.println("curso añadido");
			}else {
				System.out.println("error en el alta del curso");
			}
		}
		catch(DateTimeParseException ex) {
			System.out.println("Fecha incorrecta, el pedido no se ha añadido");
		}
	}

	static void alumnosCurso() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Denominación: ");
		String denominacion=sc.nextLine();
		
		List<Alumno> alumnos=service.buscarAlumnosCurso(denominacion);
		alumnos.forEach(a->{
			System.out.print("Nombre: "+a.getNombre());
			System.out.print("  Edad: "+a.getEdad());
			System.out.print("  Email: "+a.getEmail());
			System.out.println();
		});
	}
	
	static void buscarAlumno() {
		Scanner sc=new Scanner(System.in);
		System.out.println("DNI: ");
		String dni=sc.nextLine();
		Optional.ofNullable(service.alumnoDni(dni)).ifPresentOrElse(a->System.out.println(a.getNombre()), 
				()->System.out.println("No existe"));
	}
}
