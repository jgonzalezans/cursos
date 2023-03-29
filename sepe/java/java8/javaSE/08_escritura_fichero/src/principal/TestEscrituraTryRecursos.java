package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscrituraTryRecursos {

	public static void main(String[] args) throws FileNotFoundException {
		String ruta="c:\\mis documentos\\prueba.txt";
		//escribimos datos en un fichero de texto manteniendo su contenido
		FileOutputStream fo=new FileOutputStream(ruta, true);		
		try (fo; //ojo, esto solo es posible desde Java 9
				PrintStream out=new PrintStream(fo);){
			out.println("esto se añade");
			out.println(390);
			out.println("más cosas");
			System.out.println("Datos enviados al fichero");			
			
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
