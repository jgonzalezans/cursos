package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import model.Alumno;
import utilities.Utilidades;

public class AlumnosService {

	String ruta = "C:\\temp\\notas.txt";
	Path path;

	public AlumnosService() {
		path = Path.of(ruta);
	}
	
	// alta alumno
	
	public void altaAlumno(Alumno alumno) {
		try {
			Files.writeString(
					path,
					String.valueOf(Utilidades.convertirAlumnoATexto(alumno)), 
					StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// comprobar si existe dni
	
	public boolean existeDNI(String dni) {
		try {
			return Files.lines(path)
					.map(a->Utilidades.convertirTextoAlumno(a))
					.anyMatch(a->a.getDni().equals(dni));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	// lista de alumnos por curso

		public List<Alumno> listaAlumnosPorCurso(String curso) {
			try {
				return Files.lines(path)
						.map(a->Utilidades.convertirTextoAlumno(a))
						.filter(a->a.getCurso().equals(curso))
						.collect(Collectors.toList());
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return null;
		}
	// alumno a partir de dni

		public Alumno listaAlumnosPorDni(String dni) {
			try {
				return Files.lines(path)
						.map(a->Utilidades.convertirTextoAlumno(a))
						.filter(a->a.getDni().equals(dni))
						.findFirst()
						.orElse(null);
						
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return null;
		}
	// nota media por curso
		
		public OptionalDouble notaMedia(String curso) {
			try {
				return Files.lines(path)
						.map(a->Utilidades.convertirTextoAlumno(a))
						.filter(a->a.getCurso().equals(curso))
						.mapToDouble(a->a.getNota())
						.average();
						
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return OptionalDouble.empty();
		}

	// alumno con mayor nota
		
		
		public Optional<Alumno> alumnoConMayorNota() {
			try {
				return Files.lines(path)
						.map(a->Utilidades.convertirTextoAlumno(a))
						.max((a,b)->a.getNota()>b.getNota()?1:-1);
						
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return Optional.empty();
		}
}
