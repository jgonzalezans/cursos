package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Ciudad;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Ciudad> ciudades=new ArrayList<Ciudad>(List.of(new Ciudad("Madrid",30.5),
																 new Ciudad("Avila",20.1),
																 new Ciudad("Sevilla",33.7),
																 new Ciudad("Logroño",19.5)));
		/*
		//ordena las ciudades y muestralas
		//Collections.sort(ciudades);
		//ordenamos por temperatura
		ciudades.sort((a,b)->a.getTemperatura()>b.getTemperatura()?1:-1);
		//ciudades.sort((a,b)->a.getTemperatura()-b.getTemperatura());
		ciudades.forEach(c->System.out.println(c.getNombre()));
		
		//ordenamos por nombres de ciudades
		ciudades.sort((a,b)->b.getNombre().compareTo(a.getNombre()));
		ciudades.forEach(c->System.out.println(c.getNombre()));
		*/
		
		//¿Cuantas ciudades tienen una temperatura superior a 25 grados?
		System.out.println(ciudades.stream()
			.filter(c->c.getTemperatura()>25)
			.count());
		
		//Mostrar los nombres de las ciudades con temperatura superior a 25 grados
		ciudades.stream()
			.filter(c->c.getTemperatura()>25)
			.forEach(c->System.out.println(c.getNombre()));
		
		
		//Nombre de la ciudad más fría
		
		
		System.out.println(
				"Nombre de la ciudad más fría: "+
						ciudades.stream()
				.min((a,b) -> a.getTemperatura()>b.getTemperatura()?1:-1)
				.get()
				.getNombre()
				);
		
		//Temperatura media de todas las ciudades
		
		System.out.println(
				"Temperatura media de las ciudades: "+
				ciudades.stream()
				.mapToDouble(e->e.getTemperatura())
				.average()
				.orElse(0)
				);
		
		//¿Existe la ciudad Santander?
		
		String ciudad = "Santander";
		
		ciudades.stream()
		.anyMatch(p->p.getNombre().equals(ciudad));
		
		//¿Todas las ciudades superan los 20 grados?
		
		ciudades.stream()
		.allMatch(a->a.getTemperatura()>20);
		
	}

}
