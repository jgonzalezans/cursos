package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LanzarTareas {

	public static void main(String[] args) {
		String [] nombres={"ana","luis","alvaro","carlos","marina","alicia"};
		Path path=Path.of("C:\\tempo\\names.txt");
		ExecutorService executor=Executors.newCachedThreadPool();
		//creamos tareas
		Runnable tareaFichero=()->{
			try {
				Files.write(path, Arrays.asList(nombres));
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		};
		
		Runnable tareaContar=()->System.out.println("Total que empiezan por a :"+Arrays.stream(nombres)
														.filter(s->s.startsWith("a"))
														.count());

		Runnable tareaImprimir=()->Arrays.stream(nombres)
									.filter(s->s.length()>5)
									.forEach(System.out::println);
		
		//ponemos en ejecución las tareas
		executor.submit(tareaFichero);
		executor.submit(tareaContar);
		executor.submit(tareaImprimir);
		
		executor.shutdown();
	}

}
