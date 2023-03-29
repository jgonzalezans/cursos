package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscrituraAppend {

	public static void main(String[] args) {
		String ruta="c:\\mis documentos\\prueba.txt";
		//escribimos datos en un fichero de texto manteniendo su contenido
		FileOutputStream fo=null;
		PrintStream out=null;
		try {
			fo=new FileOutputStream(ruta, true);
			out=new PrintStream(fo);
			out.println("esto se añade");
			out.println(390);
			out.println("más cosas");
			System.out.println("Datos enviados al fichero");			
			
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}	
		finally {
			if(out!=null) {
				out.close();
			}
			if(fo!=null) {
				try {
					fo.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
			}			
		}
	}

}
