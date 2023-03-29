package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor=Executors.newCachedThreadPool();
		//executor.submit(()->IntStream.rangeClosed(1, 200).sum()); //suma de todos los números
		Future<Integer> future=executor.submit(()->IntStream.rangeClosed(1, 7).reduce(1, (a,b)->a*b)); //factorial de un número
		//el programa sigue con sus tareas
		for(int i=1;i<=1000;i++) {
			System.out.println("haciendo algo..."+i);
			if(future.isDone()) {
				System.out.println("---------------El factorial de 7 es: "+future.get());
			}
		}
			
			
	}

}
