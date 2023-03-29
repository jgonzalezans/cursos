package principal;

public class DadoMarcos {
	// Realliar un programa que simule el lanzamiento de un dado 10000 veces
	// despues nos dira el procentaje obejnido de cada vañpr
	public static void main(String[] args) {
		int nveces = 10000;
		int tirada;
		int veces[];
		

		veces = new int[6];

		for (int i = 0; i < nveces; i++) {
			tirada = (int) (Math.random() * 6 + 1);
			veces[tirada - 1]++;
			System.out.println("Has sacado un " +tirada);
		}

		for (int i = 0; i < veces.length; i++) {
			int numero = i + 1;
			System.out.println("Apariciones del número " + numero + " :" + veces[i]);
			double porcentaje = ((veces[i]) / 10000) * 100.0;
			System.out.println("Porcentaje " + numero + " :" + porcentaje);
		}

	}

}