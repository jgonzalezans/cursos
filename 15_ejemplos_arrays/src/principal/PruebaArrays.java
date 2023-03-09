package principal;

public class PruebaArrays {

	public static void main(String[] args) {
		int[] numeros=new int[5];//las posiciones se inicializan con el valor por defecto
		int[] datos= {9,3,5,16,4};
		numeros[3]=123;
		for(int i=0;i<5;i++) {
			System.out.println(numeros[i]+":"+datos[i]);
		}

	}

}
