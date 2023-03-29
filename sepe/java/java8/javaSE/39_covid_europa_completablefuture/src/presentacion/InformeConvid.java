package presentacion;

import java.text.NumberFormat;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import service.CovidEuropaService;

public class InformeConvid {

	public static void main(String[] args) {
		/*LocalDate fecha=LocalDate.now();
		double num=473984.34;
		//formateado
		DateTimeFormatter formater=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(1); //solo un decimal
		System.out.println(fecha.format(formater));
		System.out.println(nf.format(num));*/
		ExecutorService executor=Executors.newCachedThreadPool();
		
		NumberFormat nf=NumberFormat.getNumberInstance();
		
		CovidEuropaService service=new CovidEuropaService();
		//lanzamos la tarea asíncronamente
		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->service.acumuladosTotal(),executor);
		//definimos el consumer a ejecutar cuando se complete la tarea y se obtenga el resultado
		future.whenCompleteAsync((r,ex)->System.out.println("Acumulado total en Europa: "+nf.format(r)));
		
		service.listaPaises()
		.forEach(s->
			System.out.println("pais: "+s+"  Incidencia:"+nf.format(service.incidenciaPais(s))+"  Acumulados:"+nf.format(service.acumulados(s)))			
		);
		 
		executor.shutdown();
		
	}

}
