package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import task.GuardarNombresTask;
import task.NombresEmpiezanATask;

public class NombresMain {

	public static void main(String[] args) {
		
		String ruta="nombresMultitarea.txt";
		Path path;
		
			path=Path.of(ruta);
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		

		String [] nombres={"ana","luis","alvaro","carlos","marina","alicia"};

		//- guarda los nombres en un fichero
		
		
		for (int i = 0; i < nombres.length; i++) {
			
			String nombre = nombres[i];
			
			new Thread(new GuardarNombresTask(path,nombre)).start();
		}
		
		
		
		
		
		
		
		
		//- indica cuantos nombres empiezan por "a"
		
		NombresEmpiezanATask nombresPorATask = new NombresEmpiezanATask();
		
		
		
		
		//- muestra los que tienen más de 5 caracteres
		
		
	}

}
