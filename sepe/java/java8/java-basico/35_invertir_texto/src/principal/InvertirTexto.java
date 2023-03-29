package principal;

import java.util.Scanner;

//hacer un programa que solicite un texto y lo muestre invertido
public class InvertirTexto {

	public static void main(String[] args) {
		/*String texto;
		String aux=""; //cadena vacía
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce texto");
		texto=sc.nextLine();
		//recorremos la cadena al revés, desde el último caracter al primero
		
			aux=aux+texto.charAt(i);
		}
		System.out.println(aux);*/
		
		//solución más limpia
		StringBuilder texto;
		StringBuilder aux=new StringBuilder("");
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce texto");
		texto=new StringBuilder(sc.nextLine());
		for(int i=texto.length()-1;i>=0;i--) {
			aux.append(texto.charAt(i));
		}
		System.out.println(aux.toString());
	}

}
