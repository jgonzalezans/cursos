package principal;

public class TotalPares {

	public static void main(String[] args) {
		int num1=18;
		int num2=9;
		int contadorPares=0;
		//nos aseguramos que en las variables menor y mayor
		//estén los valores más pequeño y más grande, respectivamente
		//int menor=num1<num2?num1:num2;
		//int mayor=num1>num2?num1:num2;
		//usando la clase Math
		int menor=Math.min(num1, num2);
		int mayor=Math.max(num1, num2);
		
		for(int i=menor;i<=mayor;i++) {
			if(i%2==0) {
				contadorPares++;
			}
		}
		System.out.println("El total de pares es "+contadorPares);

	}

}
