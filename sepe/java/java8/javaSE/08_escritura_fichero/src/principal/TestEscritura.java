package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestEscritura {

	public static void main(String[] args) {
		String ruta="c:\\mis documentos\\prueba.txt";
		//escribimos datos en un fichero de texto
		try {
			PrintStream out=new PrintStream(ruta);
			out.println("hola de nuevo");
			out.println(600);
			out.println("sigo escribiendo");
			System.out.println("Datos enviados al fichero");
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
