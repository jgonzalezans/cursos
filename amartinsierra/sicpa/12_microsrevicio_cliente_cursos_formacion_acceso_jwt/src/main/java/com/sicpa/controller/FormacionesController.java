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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FormacionesController {
	@Autowired
	FormacionesService service;
	@ApiOperation(value="Devuelve formaciones por temática")
	@GetMapping(value="formaciones/{tematica}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> formacionesTematica(@ApiParam(value="temática de búsqueda") @PathVariable("tematica") String tematica){
		return service.formacionesTematica(tematica);
	}
	@ApiOperation(value="Añade una nueva formación y devuelve las existentes")
	@PostMapping(value="formacion",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> altaFormacion(@ApiParam(value="Datos de la nueva formación") @RequestBody Formacion formacion){
		return service.nuevaFormacion(formacion);
	}

}
