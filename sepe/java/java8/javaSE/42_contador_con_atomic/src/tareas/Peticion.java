package tareas;

import java.util.concurrent.atomic.AtomicInteger;

public class Peticion implements Runnable{
	AtomicInteger contador;
	

	public Peticion(AtomicInteger contador) {
		super();
		this.contador = contador;
		
	}


	@Override
	public void run() {
		
			System.out.println("Valor despues de incrementar: "+contador.incrementAndGet());

		
	}
	
}
