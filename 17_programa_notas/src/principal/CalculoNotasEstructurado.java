package principal;

/**
 * Partimos de un array con las notas de los alumnos. Calcular la nota media de
 * los alumnos. Calcular el nº de aprobados. Calcular la nota más alta.
 * 
 * @author joseg
 *
 */
public class CalculoNotasEstructurado {

	public static void main(String[] args) {
		// partimos de un array con las notas de los alumnos
		double[] notas = { 7.9, 2.3, 4, 5.6, 7, 8.2, 6.4 };
		// calcular la nota media
		System.out.println("La nota media es " + media(notas));
		// calcular el número de aprobados
		System.out.println("Hay " + aprobados(notas) + " aprobados");
		System.out.println("La nota más alta es: " + notaAlta(notas));
	}

	static double media(double[] datos) {
		double m = 0;
		for (double nota : datos) {
			m = m + nota;
		}
		return m / datos.length;
	}

	static double aprobados(double[] notas) {
		int aprobados = 0;
		for (double nota : notas) {
			if (nota >= 5) {
				// aprobados=aprobados+1;
				aprobados++;
			}
		}
		return aprobados;
	}

	static double notaAlta(double[] notas) {
		// calcular la nota más alta
		double notaAlta = notas[0];// inicializo la variable con la primera nota
		for (double nota : notas) {
			if (nota > notaAlta) {
				notaAlta = nota;
			}
		}
		return notaAlta;
	}
}
