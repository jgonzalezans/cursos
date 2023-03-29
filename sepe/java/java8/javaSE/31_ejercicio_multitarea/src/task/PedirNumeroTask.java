package task;

import java.util.Scanner;

import principal.TablaMultiplicar;

public class PedirNumeroTask extends Thread{

	@Override
	public void run() {
		System.out.println("Introduce el número a multiplicar: ");
		Scanner sc=new Scanner(System.in);
		int numero = sc.nextInt();
		TablaMultiplicar.numerosRecogidos.add(numero);
		}
}
