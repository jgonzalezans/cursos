package service;

import java.util.Collection;
import java.util.HashMap;

import model.Alumno;

public class AlumnosService {
	private HashMap<String,Alumno> alumnos=new HashMap<String, Alumno>();
	
	public boolean agregar(String nombre, String dni, String curso, double nota) {
		if(!alumnos.containsKey(dni)) {
			alumnos.put(dni, new Alumno(nombre,dni,curso,nota));
			return true;
		}
		return false;
	}
	//si no existiese ese dni, devolverá null
	public Alumno buscarAlumno(String dni) {
		return alumnos.get(dni);
	}
	
	public double notaMedia() {
		double media=0;
		Collection<Alumno> valores=alumnos.values();
		for(Alumno al:valores) {
			media+=al.getNota();
		}
		return media/alumnos.size();
	}
	
	public Alumno alumnoNotaMayor() {
		double notaMax=0;
		Alumno alumno=null;
		Collection<Alumno> valores=alumnos.values();
		for(Alumno al:valores) {
			if(al.getNota()>notaMax) {
				notaMax=al.getNota();
				alumno=al;
			}
		}
		return alumno;
		
	}
}
