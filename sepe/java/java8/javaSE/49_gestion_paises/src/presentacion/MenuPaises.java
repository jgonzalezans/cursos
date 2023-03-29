package presentacion;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.PaisesService;
import service.VolcadosService;

public class MenuPaises {
	static PaisesService pservice=new PaisesService();
	static VolcadosService vservice=new VolcadosService();
	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();		
		executor.submit(()->vservice.actualizarBD());
	
		int opcion;
	
		Scanner sc = new Scanner(System.in);
	
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				paisesPorContinente();
				break;
			case 2:
				paisPorCapital();
				break;
			case 3:
				paisesPorPoblacion();
				break;
			}
	
		} while (opcion != 4);
	
		executor.shutdown();
	}



static void mostrarMenu() {
	System.out.println("Seleccione opción: ");
	System.out.println("------------------");
	System.out.println("1.-Pais por continente: ");
	System.out.println("2.-Pais por capital: ");
	System.out.println("3.-Pais por poblacion: ");
	System.out.println("4.-Salir");

}

static public void paisesPorContinente() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduzca Continente: ");
	String continente = sc.nextLine();
	pservice.paisesContinente(continente).forEach(p->System.out.println(p.getNombre()));

}
static public void paisPorCapital() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduzca capital: ");
	String capital = sc.nextLine();
	Optional.ofNullable(pservice.paisCapital(capital)).ifPresentOrElse(p->System.out.println(p.getNombre()), 
									()->System.out.println("No existe capital"));



}
static public void paisesPorPoblacion() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduzca poblacion: ");
	Long poblacion = Long.parseLong(sc.nextLine());
	pservice.paisPoblacion(poblacion).forEach(p->System.out.println(p.getNombre()));
}
	
}
