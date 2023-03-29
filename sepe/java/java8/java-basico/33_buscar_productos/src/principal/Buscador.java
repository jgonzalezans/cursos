package principal;

import java.util.Scanner;

//solicita la introducción de un producto y nos indica
//cuantas veces aparece ese producto en la lista
public class Buscador {
	public static void main(String[] args) {
		String productos="pelota, pan,agua,pan ,vino,pelota ,pan,leche,papel,Pan,vino";
		int contador=0;
		String producto;
		Scanner sc=new Scanner(System.in);
		String[] valores=productos.split(",");
		System.out.println("Introduce un producto:");
		producto=sc.nextLine().toLowerCase();
		for(String cad:valores) {
			//quitamos espacios en cada producto y lo convertimos a minúscula
			//antes de comparar
			if(cad.trim().toLowerCase().equals(producto)) {
				contador++;
			}
		}
		System.out.println("El total de veces que aparece el producto es: "+contador);

	}

}
