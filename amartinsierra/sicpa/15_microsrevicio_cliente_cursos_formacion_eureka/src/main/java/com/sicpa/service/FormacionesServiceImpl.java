package com.sicpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sicpa.model.Credentials;
import com.sicpa.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String pwd;
	
	String token;
	
	@Autowired
	RestTemplate template;
	
	//String url="http://localhost:7000/";
	String url="http://servicio-cursos/";
	//nos autenticamos al principio y obtenemos el token
	//@PostConstruct
	public void init() {
		if(token==null||token.equals("")) {
			Credentials credentials=new Credentials(user,pwd);
			
			token=template.postForObject(url+"login", credentials,String.class);
		}
	}

	@Override
	public List<Formacion> formacionesTematica(String tematica) {
		init();
		Formacion[] formaciones=template.exchange(url+"cursos",
											HttpMethod.GET,
											new HttpEntity<Void>(getHeaders()),
											Formacion[].class).getBody();
		return Arrays.stream(formaciones)
		.filter(f->f.getTematica().equals(tematica))
		.peek(f->f.setAsignaturas(f.getDuracion()/10))
		.collect(Collectors.toList());
	}

	@Override
	public List<Formacion> nuevaFormacion(Formacion formacion) {
		init();
		template.exchange(url+"curso", HttpMethod.POST,new HttpEntity<Formacion>(formacion,getHeaders()),Void.class);
		return Arrays.stream(template.exchange(url+"cursos",
												HttpMethod.GET,
												new HttpEntity<Void>(getHeaders()),
												Formacion[].class).getBody())
				.peek(f->f.setAsignaturas(f.getDuracion()/10))
				.collect(Collectors.toList());
	}

	@Override
	public boolean actualizarFormacion(Formacion formacion) {
		init();
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
		init();
		//método exchage permite cualquier petición Http, con acceso a respuesta completa
		ResponseEntity<Formacion[]> response=template.exchange(url+"curso/{duracion}", 
																	HttpMethod.GET,
																	null,
																	Formacion[].class,
																	duracion);
		HttpHeaders headers=response.getHeaders();
		return Integer.parseInt(headers.get("total").get(0));
		
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		return headers;
	}
}
