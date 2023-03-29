package com.sicpa.init;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sicpa.service.CursosService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	CursosService cursosService;

	@Test
	void cursosDuracionTest() {
		assertEquals(4, cursosService.cursosCortos(50).size());
	}
	@Test
	void buscadorTest() {
		assertNotNull(cursosService.cursoDenominacion("php"));
	}
}
