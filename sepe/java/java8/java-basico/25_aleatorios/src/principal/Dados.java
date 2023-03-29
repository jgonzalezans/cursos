package principal;

/**
 * Realizar un programa que simule el lanzamiento de un dado 1000 veces.
 * Después, nos dirá el porcentaje (intentos*100) obtenido de cada valor
 * 
 * @author joseg
 *
 */
public class Dados {

	public static void main(String[] args) {
		
		int intentos = 100;
		
		int lanzamientos [] = new int [intentos];
		
		int veces [] = new int [intentos];
		
		

		for (int i = 0; i < lanzamientos.length; i++) {
			
			System.out.println("Voy a lanzar el dado...");
			
			int intento = (int) Math.floor(Math.random() * 6 + 1);
			
			lanzamientos[i] = intento;
			
			System.out.println("Has sacado un "+intento);
			
			veces[i]++;
			
			if(veces[i] > 1)
				System.out.println("Este número ha aparecido "+veces[i]+" veces");
			else 
				System.out.println("Este número ha aparecido "+veces[i]+" vez");
			
			//registro []

		}

	}

}
