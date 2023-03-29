package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TablaMultiplicar;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new TablaMultiplicar(4));
		executor.submit(new TablaMultiplicar(8));
		executor.submit(new TablaMultiplicar(3));
		executor.submit(new TablaMultiplicar(7));
		executor.shutdown();
	}

}
