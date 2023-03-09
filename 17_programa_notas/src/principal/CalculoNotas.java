package principal;

/**
 * Partimos de un array con las notas de los alumnos.
 * Calcular la nota media de los alumnos.
 * Calcular el nº de aprobados.
 * Calcular la nota más alta.
 * @author joseg
 *
 */
public class CalculoNotas {

	public static void main(String[] args) {
		
		double[] notas= {7.9,2.3,4,5.6,7,8.2,6.4};
		
		double notaMedia = 0;
		
		int aprobados = 0;
		
		double notaMasAlta = 0;
		
		for (int i = 0; i < notas.length; i++) {
			notaMedia+=notas[i];
			
			if(notas[i]>=5.0)
				aprobados++;
			
			if(notas[i]>notaMasAlta)
				notaMasAlta=notas[i];
		}
		
		System.out.println("La nota media de los alumnos es: "+notaMedia/notas.length);

		System.out.println("El número de aprobados es : "+aprobados);
		
		System.out.println("La nota mas alta es : "+notaMasAlta);
	}

}
