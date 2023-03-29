package principal;

/**
 * Hacer un programa que solicite un numero por pantalla y cuente el n�mero de veces
 * que un n�mero (variable num) aparece dentro del array
 * @author joseg
 *
 */
public class Contar {

	public static void main(String[] args) {
		
		int[] datos= {3,5,1,3,4,9,7,5,3,8,2,1};
		int num=4;
		int apariciones= 0;
		
		for (int i : datos) {
			if(i==num)
				apariciones++;
		}
		
		System.out.println("El n�mero "+num+" aparece "+apariciones+" veces");
		
	}

}
