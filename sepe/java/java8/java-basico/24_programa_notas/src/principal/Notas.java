package principal;

import java.util.Scanner;

//realizar un programa que solicite por teclado la introducci�n de cinco notas
//que ser�n guardadas en un array. Las notas le�das, deben estar entre 1 y 10, si introduce
//un valor que no est� en ese rango, se escribir� un mensaje y se volver� a leer esa nota
public class Notas {

	public static void main(String[] args) {
		double[] notas=new double[5];
		double nota;
		Scanner sc=new Scanner(System.in);
		//soluci�n 1 no correcta al 100%, no vale en caso de que se equivoque dos veces seguidas
		for(int i=0;i<notas.length;i++) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			if(nota<1||nota>10) {
				System.out.println("La nota no es v�lida,vuelvela a intrducir");
				nota=sc.nextDouble();
				notas[i]=nota;
			}else {
				notas[i]=nota;
			}
			
		}
		
		//soluci�n 2 (v�lida 100%)
		for(int i=0;i<notas.length;i++) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			while(nota<1||nota>10) {
				System.out.println("La nota no es v�lida,vuelvela a intrducir");
				nota=sc.nextDouble();
			}
			notas[i]=nota;			
		}
		
		//solucion 3 (v�lida 100%)
		int notasLeidas=0;
		while(notasLeidas<=notas.length) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			if(nota>=1&&nota<=10) {
				notas[notasLeidas]=nota;
				notasLeidas++;
			}else {
				System.out.println("Nota no v�lida, repitela ");
			}
		}
		
		
	}

}
