package principal;

import java.util.Scanner;

//realizar un programa que solicite por teclado la introducción de cinco notas
//que serán guardadas en un array. Las notas leídas, deben estar entre 1 y 10, si introduce
//un valor que no esté en ese rango, se escribirá un mensaje y se volverá a leer esa nota
public class Notas {

	public static void main(String[] args) {
		double[] notas=new double[5];
		double nota;
		Scanner sc=new Scanner(System.in);
		//solución 1 no correcta al 100%, no vale en caso de que se equivoque dos veces seguidas
		for(int i=0;i<notas.length;i++) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			if(nota<1||nota>10) {
				System.out.println("La nota no es válida,vuelvela a intrducir");
				nota=sc.nextDouble();
				notas[i]=nota;
			}else {
				notas[i]=nota;
			}
			
		}
		
		//solución 2 (válida 100%)
		for(int i=0;i<notas.length;i++) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			while(nota<1||nota>10) {
				System.out.println("La nota no es válida,vuelvela a intrducir");
				nota=sc.nextDouble();
			}
			notas[i]=nota;			
		}
		
		//solucion 3 (válida 100%)
		int notasLeidas=0;
		while(notasLeidas<=notas.length) {
			System.out.println("Introduce una nota: ");
			nota=sc.nextDouble();
			if(nota>=1&&nota<=10) {
				notas[notasLeidas]=nota;
				notasLeidas++;
			}else {
				System.out.println("Nota no válida, repitela ");
			}
		}
		
		
	}

}
