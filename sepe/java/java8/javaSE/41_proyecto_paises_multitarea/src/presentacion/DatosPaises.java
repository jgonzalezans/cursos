package presentacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Pais;
import service.PaisesService;

public class DatosPaises {

	public static void main(String[] args) {
		PaisesService service=new PaisesService();
		ExecutorService executor=Executors.newCachedThreadPool();
		CompletableFuture<List<String>> future1=CompletableFuture.supplyAsync(()->service.nombresContinentes(),executor);
		future1.whenCompleteAsync((r,ex)->{
			System.out.println("-------Población de todos los continentes:-------");
			 r
			.forEach(c->System.out.println(c+":"+service.poblacionTotal(c)));
		});
		
		CompletableFuture<Pais> future2=CompletableFuture.supplyAsync(()->service.paisMasPoblado(), executor);
		future2.whenCompleteAsync((r,ex)->{
			System.out.println("-------Datos del pais más poblado:-------");
			
			System.out.println("Nombre: "+r.getName());
			System.out.println("Capital: "+r.getCapital());
			System.out.println("Población: "+r.getPopulation());
		});
		
		//executor.shutdown();
	}

}
