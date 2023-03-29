package com.sicpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicpa.model.Formacion;
import com.sicpa.service.FormacionesService;

@RestController
public class FormacionesController {
	@Autowired
	FormacionesService service;
	@GetMapping(value="formaciones/{tematica}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> formacionesTematica(@PathVariable("tematica") String tematica){
		return service.formacionesTematica(tematica);
	}
	
	@PostMapping(value="formacion",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> altaFormacion(@RequestBody Formacion formacion){
		return service.nuevaFormacion(formacion);
	}

}
