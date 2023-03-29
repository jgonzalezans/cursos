package com.sicpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicpa.dao.CursosDao;
import com.sicpa.model.Curso;

@Service
public class CursosServiceImpl implements CursosService{
	
	CursosDao cursosDao;

	public CursosServiceImpl(@Autowired CursosDao cursosDao) {
		super();
		this.cursosDao = cursosDao;
	}

	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Curso> cursosCortos(int duracionMax) {
		return cursosDao.findShortCourses(duracionMax);
	}

	@Override
	public Curso cursoDenominacion(String denominacion) {
		return cursosDao.findByDenominacion(denominacion);
	}

	@Override
	public void eliminarCurso(String denominacion) {
		if(cursoDenominacion(denominacion)!=null) {
			cursosDao.deleteByDenominacion(denominacion);
		}
		
	}

	@Override
	public Curso altaCurso(Curso curso) {
		if(cursoDenominacion(curso.getDenominacion())==null) {
			cursosDao.save(curso);
			return curso;
		}
		return null;
	}

	@Override
	public boolean actualizarCurso(Curso curso) {
		if(cursosDao.findById(curso.getCodigocurso()).isPresent()) {
			cursosDao.save(curso);
			return true;
		}
		return false;
	}
	

}
