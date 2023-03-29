package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Escritura {

	public static void main(String[] args) {

		String ruta = "prueba.txt";
		
		PrintStream out;
		try {
			out = new PrintStream(ruta);
			out.println("hola que tal");
			out.println(200);
			out.println("adios");
			System.out.println("Datos enviados al fichero");
		} catch (FileNotFoundException e) {
			System.out.println("La ruta no existe");
		}
		
		
	}

}
