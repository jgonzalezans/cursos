/**
 * Realizar un programa que nos indique hasta que número natural,
 * empezando por el 1, tendremos que sumar para llegar o superar 1000
 * @author joseg
 *
 */
public class SumaMil {

	public static void main(String[] args) {
		
		int suma = 0;
		int contador = 0;
		
		while (suma < 1000) {
			contador++;
			System.out.println("Valor de suma: "+suma);
			System.out.println("Valor de contador: "+contador);
			suma+=contador;
		}

		System.out.println("Hemos tenido que llegar hasta el : "+contador);
	}
}