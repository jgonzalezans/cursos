package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import model.Medida;
import utilities.Utilidades;

public class CovidServiceProfesor {
	String dir="c:\\tempo\\ciudades.txt";
	Path path=Path.of(dir);
	//lista de nombres de todas las localidades
	public List<String> localidades(){
		try {
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.map(Medida::getNombre) //Stream<String> nombres
					.distinct() //Stream<String> sin duplicados
					.collect(Collectors.toList());  //List<String>
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return List.of(); //lista vacía
		}
	}

	//lista de medidas tomadas a partir de una determinada fecha
	public List<Medida> medidasFecha(Date fecha){
		try {
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.filter(m->m.getFechaMuestra().after(fecha))
					.collect(Collectors.toList());  //List<Medida>
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return List.of(); //lista vacía
		}
	}
	//media de incidencia de la localidad recibida como parámetro
	public OptionalDouble mediaCiudad(String ciudad){
		try {
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.filter(m->m.getNombre().equals(ciudad))
					.mapToDouble(m->m.getIncidencia()) //DoubleStream
					.average();  //OptionalDouble
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return OptionalDouble.empty(); //vacío
		}
	}
	private Date fechaMasReciente(){
		try {
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.max((m1,m2)->m1.getFechaMuestra().compareTo(m2.getFechaMuestra())) //Optional<Muestra>
					.orElse(new Medida())
					.getFechaMuestra();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}



	//incidencia media actual (correspondiente a la fecha más reciente)
	public OptionalDouble mediaActual(){
		try {
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.filter(m->m.getFechaMuestra().equals(fechaMasReciente()))
					.mapToDouble(m->m.getIncidencia()) //DoubleStream
					.average();  //OptionalDouble
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return OptionalDouble.empty(); //vacío
		}
	}

}
