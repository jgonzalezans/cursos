package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestLectura {
	
	//lee todas las líneas del fichero y las muestra en la consola
	public static void main(String[] args) {
		String ruta="c:\\mis documentos\\prueba.txt";
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){
			/*String linea;
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}*/
			
			//con programación funcional
			bf.lines()
			.forEach(l->System.out.println(l));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
