package com.sicpa.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	@GetMapping(value="saludar",produces=MediaType.TEXT_PLAIN_VALUE)
	public String getSaludo() {
		return "Bienvenido a mi servicio REST";
	}
	@GetMapping(value="saludar/{n}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String getSaludoPersonal(@PathVariable("n") String name) {
		return "Bienvenido/a "+name+" a mi servicio REST";
	}
	@GetMapping(value="saludarcompleto",produces=MediaType.TEXT_PLAIN_VALUE)
	public String getSaludoCompleto(@RequestParam("type") String tipo,@RequestParam("name") String name) {
		return tipo+" "+name+" este es mi servicio REST";
	}
	
}
