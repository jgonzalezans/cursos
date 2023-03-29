package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tareas.Peticion;

public class Lanzador {

	public static void main(String[] args) {
		AtomicInteger ai=new AtomicInteger();
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.submit(new Peticion(ai));
		executor.submit(new Peticion(ai));
		executor.submit(new Peticion(ai));
		
		executor.shutdown();
	}

}
