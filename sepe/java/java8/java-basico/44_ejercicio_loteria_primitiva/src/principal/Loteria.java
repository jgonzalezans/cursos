package principal;

import java.util.Arrays;

public class Loteria {
	public static void main(String[] args) {
		int[] numeros = new int[6];
		generarCombinacion(numeros);
		ordenar(numeros);
		mostrar(numeros);
	}//FIN M�TODO MAIN
	
	
	//M�todo para generar combinacion
	//Crear un n�mero, antes de meterlo en el array miro si ya lo ten�a, si no, lo
	//meto en el array. Se mira si est� repetido en lo que llevo, y se guarda.
	static void generarCombinacion(int[] numeros){
		int num = 1;
		int i = 0; //lleva la cuenta de los n�meros no repetidos generados hasta el momento
		while(i < numeros.length) {
			num = (int)(Math.random()*49+1);
			if (!numRepetido(numeros, num)) {
					numeros[i] = num;
					i++;
			}//fin if
		}//fin while
		
	}//fin generarCombinacion
	
	//M�todo para comprobar si existe el n�mero
	static boolean numRepetido(int[] numeros, int num) {
		/*boolean resultado=false;
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == num) {
				resultado=true;
				break; //ya no hace falta seguir
			}//fin if
		}//fin for
		return resultado;*/
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == num) {
				return true; //salimos directamente si encontramos repetido
			}//fin if
		}//fin for
		return false;
	}//fin numRepetido
	
	
	//M�todo para mostrar los n�meros de la loter�a (M�todo burbuja para ordenar)
	//Se muestran ordenados de menor a mayor
	static void ordenar(int[] numeros) {
	/*		int aux;
			for (int i = 0; i < numeros.length; i++) {
				for (int j = i; j < numeros.length; j++) {
					if (numeros[j] < numeros[i]) {
						aux = numeros[j];
						numeros[j] = numeros[i];
						numeros[i] = aux;
					}//fin if
				}//fin for segundo
			}//fin for	
	*/
		Arrays.sort(numeros);

	}//fin mostrarNumeros
	static void mostrar(int[] numeros) {
		//Recorro para mostrar el resultado
		for (Integer num:numeros) {
			System.out.print(num+"-");
		}//fin for
		
		System.out.println(Arrays.toString(numeros));
	}
}
