package com.sicpa.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sicpa.model.FichaCliente;

@RestController
public class FichaController {
	@GetMapping(value="ficha/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public FichaCliente fichaCliente(@PathVariable("name") String nombre) {
		return new FichaCliente(nombre, "test@gmail.com", 35);
	}
}
