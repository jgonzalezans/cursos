package task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class GuardarNombresTask implements Runnable {
	
	String nombre;
	Path path;

	public GuardarNombresTask(Path p, String n) {
		
		path = p;
		nombre = n;
		
	}

	@Override
	public void run() {
		
		try {
			Files.writeString(path, String.valueOf(nombre)+"\n",StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			
			ex.printStackTrace();
		}	
	}

}
