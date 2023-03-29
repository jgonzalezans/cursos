package com.sicpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicpa.model.Curso;
import com.sicpa.service.CursosServiceImpl;

@CrossOrigin(value = "*")
@RestController
public class CursosController {
	@Value("${eureka.instance.instance-id}")
	String instancia;
	@Autowired
	CursosServiceImpl cursosService;
	@GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> catalogoCursos(){
		System.out.println("Instancia en ejecución "+instancia);
		return cursosService.cursos();
	}
	
	@GetMapping(value="cursos/{duracion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> cursosDuracion(@PathVariable("duracion") int duracion){
		HttpHeaders headers=new HttpHeaders();
		List<Curso> resultado=cursosService.cursosCortos(duracion);
		headers.add("total", String.valueOf(resultado.size()));
		return new ResponseEntity<>(resultado,headers,HttpStatus.OK);
	}
	@GetMapping(value="curso/{denominacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscadorDenominacion(@PathVariable("denominacion") String denominacion) {
		return cursosService.cursoDenominacion(denominacion);
	}
	@DeleteMapping(value="curso/{denominacion}")
	public void eliminarCurso(@PathVariable("denominacion") String denominacion) {
		cursosService.eliminarCurso(denominacion);
	}
	@PostMapping(value="curso",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso alta(@RequestBody Curso curso) {
		return cursosService.altaCurso(curso);
	}
	@PutMapping(value="curso",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Void> actualizar(@RequestBody Curso curso) {
		return cursosService.actualizarCurso(curso)?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
}
