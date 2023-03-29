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

public class CovidService {

	String ruta = "covid_madrid_abril_2021.csv";
	Path path;
	
	public CovidService() {
		path = Path.of(ruta);
	}
	
	//lista de nombres de todas las localidades
	
	public List<String> getNombresLocalidad(){
		
		try {
			
			return Files.lines(path)
			.map(l->Utilidades.convertirTextoMedida(l)
				.getNombre())
			.collect(Collectors.toList());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//lista de medidas tomadas a partir de una determinada fecha
	
	public List<Medida> getMedidasByDate(Date fechaDeterminada){
		
		try {
			
			return Files.lines(path)
			.map(l->Utilidades.convertirTextoMedida(l))
			.filter(m->m.getFechaMuestra().after(fechaDeterminada))
			.collect(Collectors.toList());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//media de incidencia de la localidad recibida como parámetro
	
	public OptionalDouble mediaIncidenciaByLocalidad(String localidad){
		
		try {
			
			return Files.lines(path)
			.map(l->Utilidades.convertirTextoMedida(l))
			.filter(m->m.getNombre().equals(localidad))
			.mapToDouble(m->m.getIncidencia())
			.average();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OptionalDouble.empty();
	}
	
	
	//incidencia media actual (correspondiente a la fecha más reciente)
	
	public OptionalDouble incidenciaMediaActual(){
		
		try {			
			return Files.lines(path) //Stream<String> cadenas del fichero
					.map(l->Utilidades.convertirTextoMedida(l))  //Stream<Medida> 
					.filter(m->m.getFechaMuestra().equals(fechaMasReciente()))
					.mapToDouble(m->m.getIncidencia()) //DoubleStream
					.average();  //OptionalDouble
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OptionalDouble.empty();
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
}
