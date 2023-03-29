package tareas;

import java.util.concurrent.locks.Lock;

import recursos.Contador;

public class Peticion implements Runnable{
	Contador contador;
	Lock lock;

	public Peticion(Contador contador, Lock lock) {
		super();
		this.contador = contador;
		this.lock=lock;
	}


	@Override
	public void run() {
		//muchas instrucciones
		lock.lock();
			contador.incrementar();
			System.out.println("Valor despues de incrementar: "+contador.getValor());
		lock.unlock();
		
		//muchas instrucciones
		
	}
	
}
