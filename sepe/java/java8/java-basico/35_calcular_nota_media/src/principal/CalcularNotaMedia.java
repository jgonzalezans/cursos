package principal;

/**
 * Dado un grupo de notas existentes en una cadena de caracteres, calcular la
 * nota media
 * 
 * @author joseg
 *
 */

public class CalcularNotaMedia {

	public static void main(String[] args) {

		String cadena = "5.6,8.9,6.7,3.2,6.3,7.5"+21+541.25;
		
		System.out.println(cadena);

		String[] cadenaSplit = cadena.trim().split(",");
		
		double nota = 0.0;

		for (String numeroTexto : cadenaSplit) {

			nota += Double.parseDouble(numeroTexto);

		}
		nota = nota / cadenaSplit.length;

		System.out.println("La nota media es: " + nota);

	}

}
