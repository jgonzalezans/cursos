package com.sicpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sicpa.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {
	/*
	 Los métodos findAll, findById y save ya los heredamos
	 */
	Curso findByDenominacion(String denominacion);
	@Query(value = "select c from Curso c where c.duracion<=?1")
	List<Curso> findShortCourses(int duracion);
	@Transactional
	@Modifying
	void deleteByDenominacion(String denominacion);
}
