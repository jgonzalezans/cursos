package main;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Pais;
import service.PaisesService;


/**
 * 
 * Realizar un programa que nos permita realizar una serie de operaciones sobre una tabla de paises
 * existente en una base de datos.
 * 
 * La tabla de paises tendr� los siguientes campos: idpais, nombre, poblacion, capital, continente. 
 * 
 * Las funciones ser�n las siguientes:
 * 
 * -Consulta de paises por continente
 * -Pais a partir de su capital
 * -Consulta de paises con poblaci�n inferior a par�metro.
 * 
 * Cada vez que se inicie la aplicaci�n, la base de datos se debe actualizar con la informaci�n
 * del servicio https://restcountries.com/v2/all. tarea que ser� llevada a cabo por un proceso que
 * se ejecuta en segundo plano

 * @author joseg
 *
 */

public class PaisesApplication {

	public static void main(String[] args) {

		actualizarBD();
		
		//TODO:
		/* 
		-Consulta de paises por continente
		-Pais a partir de su capital
		-Consulta de paises con poblaci�n inferior a par�metro.*/
		
		
	}

	private static void actualizarBD() {

		PaisesService paisesService=new PaisesService();

		ExecutorService executor=Executors.newCachedThreadPool();

		CompletableFuture<List<Pais>> future = CompletableFuture.supplyAsync(()->paisesService.getPaises(),executor);

		future.whenCompleteAsync((listaPaises,ex)->{
			log("Actualizando base de datos...");
			long inicio = System.currentTimeMillis();
			listaPaises.forEach(pais->paisesService.addPais(pais));
			long duracion = System.currentTimeMillis() - inicio;
			log("Base de datos actualizada -> "+Instant.now());
			log("Duraci�n del proceso: "+duracion/1000F+" segundos");
		});
		
		//executor.shutdown();

		//FIXME: Hay que cerrar el executor o no?
		//executor.awaitTermination(0, null)

	}
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}

}
