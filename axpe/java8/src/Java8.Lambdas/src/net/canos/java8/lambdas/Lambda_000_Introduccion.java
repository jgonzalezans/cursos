package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Lambda_000_Introduccion {
	
	public static void main(String[] args) {
		List<Integer> f = Arrays.asList(0,1,1,2,3,5,8,13,21,34,55);
		
		/*
		 * UPDATE 1. 
		 * Ejemplo forEach
		 */
		System.out.println("UPDATE 1) FOR EACH");
		System.out.println("**********************");
		f.forEach( p -> System.out.print(p+",") );
		
		System.out.println("\n\n");
		
	
		/*
		 * UPDATE 2. Lambda puede tener varias instrucciones, no solo una.
		 * Pasa a tener llaves
		
		System.out.println("UPDATE 2) FOR EACH múltiples instrucciones");
		System.out.println("**********************");
		f.forEach(p -> {
			System.out.print(p);
			System.out.print(p+1);			
		});
		System.out.println("\n\n");
		*/
		
		
		/*
		 * UPDATE 3. Lambda limitación final
		 * Las variables usadas dentro han de ser finales.
		 * Si no lo declaras, el compilador las declara automáticamente finales.
		 * No se permite modificar una variable final.
		 
		System.out.println("UPDATE 3) FOR EACH CON ACUMULACION no está permitido");
		System.out.println("**********************");
		final String separator = ",";
		String aux;
		f.forEach(p -> {
			// sí que va
			System.out.print(p+separator);
			// no va
			//aux += p.toString()+separator;
		});
		aux = "10";
		System.out.println("\n\n");
		 */
		
		/*
		 * UPDATE 4. Una lambda puede devolver un parámetro
		 * Por ejemplo, la función sort, quiere require que la lambda devuelva un valor integer 
		 * compareTo, es el valor que queremos, ya que devuelve un Integer <0,0,>0 según la relación entre los parámetros sea menor, igual o mayor.
		 * Al múltiplicar por -1 estamos reordenando inversamente, de mayor a menor.
		
		System.out.println("UPDATE 4) Devolución de parámetros");
		System.out.println("**********************");
		
		f.sort((e1,e2) -> {
			return e1.compareTo(e2) * -1;
		});
		System.out.println(f);
		System.out.println("\n");
		 */
		
		
		/*
		 * UPDATE 5. Una lambda de una instrucción se devuelve sin return
		 * Tienen el return implicito
		
		System.out.println("UPDATE 5) Devolución de parámetros");
		System.out.println("**********************");
		
		f.sort((e1,e2) -> e1.compareTo(e2));
		System.out.println(f);
		System.out.println("\n");
		 */
		
		
		
		
		
		
		
		
		
		

	}

}
