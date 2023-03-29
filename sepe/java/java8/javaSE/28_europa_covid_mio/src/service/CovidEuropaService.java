package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import model.Item;

public class CovidEuropaService {
	
	String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	Item[] items;
	public CovidEuropaService() {
		Gson gson=new Gson();
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(ruta)) //Builder
							.GET() //Builder
							.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
						.version(Version.HTTP_1_1)
						.build();
		//lanzar petici�n y objeto HttpResponse

		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			items=gson.fromJson(response.body().toString(), Item[].class);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*Programa datos de covid Europa

	Item: nombrePais, casosAcumulados, fecha(LocalDate), incidencia - solo para la �ltima funcionalidad-

	Funcionalidades:

	- Lista completa de paises (List<String>)
	- Incidencia actual (double) del pais recibido como par�metro
	- Casos acumulados (int) del pais recibido como par�metro
	- Lista de items a partir de la fecha recibida como par�metro*/
	

	//- Lista completa de paises (List<String>)
	
	public List<String> nombresPaises(){
		return Arrays.stream(items) //Stream<Item>
		.map(p->p.getNombre()) //Stream<String>
		.distinct()
		.sorted()
		.collect(Collectors.toList());
	}
	
	//- Incidencia actual (double) del pais recibido como par�metro
	
	public double incidenciaPais(String nombrePais) {
		
		return Arrays.stream(items)
				.filter(p->p.equals(nombrePais))
				.mapToDouble(p->p.getIncidencia())
				.sum();
		
	}
	
	//Casos acumulados (int) del pais recibido como par�metro
	
	public int casosAcumulados(String pais){
		return Arrays.stream(items) //Stream<Item>
				.filter(p->p.getNombre().equals(pais)) //Stream<Item>
				.mapToInt(p->p.getCasosAcumulados())
				.sum();
	}
	
	//- Lista de items a partir de la fecha recibida como par�metro
	
	public List<Item> itemsPorFecha(String fecha){
			try {
				return  Arrays.stream(items) //Stream<Item>			 
				.filter(i->i.getFecha().isAfter(Utilidades.convertirTextoFecha(fecha)))
				.collect(Collectors.toList());
			} catch (Exception e) {
				e.printStackTrace();
			}  //List<Item>
			return List.of();
	}
}
