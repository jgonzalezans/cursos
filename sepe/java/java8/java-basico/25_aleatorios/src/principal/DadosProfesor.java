package principal;

/**
 * Realizar un programa que simule el lanzamiento de un dado 1000 veces.
 * Después, nos dirá el porcentaje (intentos*100) obtenido de cada valor
 * 
 * @author joseg
 *
 */
public class DadosProfesor {

	public static void main(String[] args) {

		final int tiradas = 100000;
		int[] contadores = new int[6];
		int dado;
		for (int i = 1; i <= tiradas; i++) {
			dado = (int) (Math.random() * 6 + 1);
			// si es un 1, incrementamos contador 0, si es un 2, contador 1,....
			contadores[dado - 1]++;
		}

		// mostramos los porcentajes
		for (int i = 0; i < contadores.length; i++) {
			System.out.println("Procetaje de " + (i + 1) + " es: " + (contadores[i] * 100 / tiradas) + "%");
		}

	}
}
