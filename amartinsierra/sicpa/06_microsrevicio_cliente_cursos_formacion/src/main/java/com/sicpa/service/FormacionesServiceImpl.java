package com.sicpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sicpa.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {
	@Autowired
	RestTemplate template;
	
	String url="http://localhost:7000/";

	@Override
	public List<Formacion> formacionesTematica(String tematica) {
		Formacion[] formaciones=template.getForObject(url+"cursos", Formacion[].class);
		return Arrays.stream(formaciones)
		.filter(f->f.getTematica().equals(tematica))
		.peek(f->f.setAsignaturas(f.getDuracion()/10))
		.collect(Collectors.toList());
	}

	@Override
	public List<Formacion> nuevaFormacion(Formacion formacion) {
		template.postForLocation(url+"curso", formacion);
		return Arrays.stream(template.getForObject(url+"cursos", Formacion[].class))
				.peek(f->f.setAsignaturas(f.getDuracion()/10))
				.collect(Collectors.toList());
	}

	@Override
	public boolean actualizarFormacion(Formacion formacion) {
		//si código de estado es del rango 400 o 500, genera una excepción
		try {
			template.put(url+"curso", formacion);
			return true;
		}catch(HttpClientErrorException ex) {
			//ex.getRawStatusCode() evalúa código de estado
			return false;
		}
	}

	@Override
	public int formacionesDuracionMaxima(int duracion) {
		//método exchage permite cualquier petición Http, con acceso a respuesta completa
		ResponseEntity<Formacion[]> response=template.exchange(url+"curso/{duracion}", 
																	HttpMethod.GET,
																	null,
																	Formacion[].class,
																	duracion);
		HttpHeaders headers=response.getHeaders();
		return Integer.parseInt(headers.get("total").get(0));
		
	}

}
