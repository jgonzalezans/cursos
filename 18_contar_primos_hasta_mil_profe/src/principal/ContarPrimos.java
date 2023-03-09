package principal;

public class ContarPrimos {

	public static void main(String[] args) {
		int contador=0;
		for(int num=1;num<=1000;num++) {
			
			boolean resultado=true; //de momento, suponemos que si es primo
			//vamos a recorrer todos los números entre 2 y num
			//y si encontramos una división exacta, entonces no es primo
			for(int i=2;i<num;i++) {
				if(num%i==0) {
					resultado=false;
					break;//como ya hemos visto que no es primo, no seguimos ejecutando
				}
			}
			//si uno de los números del recorrido es primo, lo mostramos
			//e incrementamos el contador de primos
			if(resultado) {
				contador++;
				System.out.println("El número "+num+" es primo");
			}else {
				System.out.println("El número "+num+" no es primo");
			}
		}
		
		System.out.println("El total de primos entre 1 y 1000 es: "+contador);
	}

}
