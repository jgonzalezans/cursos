package principal;

public class SumarPositivosArray {

	public static void main(String[] args) {
		
		int[] numeros= {7,-3,11,21,-9,28};
		int suma = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i]>0)
			suma+=numeros[i];
		}
		System.out.println("La suma total de los positivos del array es : "+suma);

	}

}
