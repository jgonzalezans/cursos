package utilities;

import model.Alumno;

public class Utilidades {
	public static Alumno convertirTextoAlumno(String linea) {
		String[] datos=linea.split(",");
		return new Alumno(datos[0],datos[1],datos[2],Double.parseDouble(datos[3]));
	}

	public static String convertirAlumnoATexto(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}
}
