package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import recursos.Contador;
import tareas.Peticion;

public class Lanzador {

	public static void main(String[] args) {
		Contador contador=new Contador();
		Lock lock=new ReentrantLock();
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.submit(new Peticion(contador, lock));
		executor.submit(new Peticion(contador, lock));
		executor.submit(new Peticion(contador, lock));
		
		executor.shutdown();
	}

}
