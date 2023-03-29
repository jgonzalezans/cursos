package presentacion;

import java.text.NumberFormat;
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
		Future<Integer> future=executor.submit(()->service.acumuladosTotal());
		
		service.listaPaises()
		.forEach(s->{
			System.out.println("pais: "+s+"  Incidencia:"+nf.format(service.incidenciaPais(s))+"  Acumulados:"+nf.format(service.acumulados(s)));
			if(future.isDone()) {
				try {
					System.out.println("Acumulado total en europa: "+future.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		 
		while(!future.isDone()) {
			
		}
		try {
			System.out.println("Acumulado total en europa: "+nf.format(future.get()));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
