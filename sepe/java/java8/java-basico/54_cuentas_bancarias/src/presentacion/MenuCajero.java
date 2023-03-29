package presentacion;

import java.util.Scanner;

import model.Movimiento;
import service.CuentaMovimientos;
import service.IteradorMovimientos;

public class MenuCajero {
	static CuentaMovimientos service;
	public static void main(String[] args) {
		var sc=new Scanner(System.in);
		System.out.println("Saldo inicial: ");
		double saldo=Double.parseDouble(sc.nextLine());
		System.out.println("L�mite de la cuenta:");
		double limite=Double.parseDouble(sc.nextLine());
		service=new CuentaMovimientos(saldo,limite);
		int opcion;
		do {

			mostrarMenu();

			opcion=sc.nextInt();

			switch (opcion) {
			case 1:
				ingresar();
				break;
			case 2:
				extraer();
				break;
			case 3:
				saldoMovimientos();
				break;
			
			}

		} while (opcion!=4);
	}

	static void ingresar() { // 1. A�adir contacto
		var sc=new Scanner(System.in);
		
		System.out.println("Introduce cantidad: ");
		double cantidad=Double.parseDouble(sc.nextLine());
		service.ingresar(cantidad);
	}
	static void extraer() { // 1. A�adir contacto
		var sc=new Scanner(System.in);
		
		System.out.println("Introduce cantidad: ");
		double cantidad=Double.parseDouble(sc.nextLine());
		service.extraer(cantidad);
	}
	static void saldoMovimientos() {
		System.out.println("Saldo: "+service.getSaldo());		
		IteradorMovimientos movimientos=service.iterador();
		/*for(Movimiento m:movimientos) {
			System.out.println("Cantidad: "+m.getCantidad()+", operaci�n: "+m.getTipo());
		}*/
		while(movimientos.hayMasElementos()) {
			Movimiento m=movimientos.siguiente();
			System.out.println("Cantidad: "+m.getCantidad()+", operaci�n: "+m.getTipo());
		}
	}
	
	static void mostrarMenu() {
		System.out.println("1.- Ingreso ");
		System.out.println("2.- Extracci�n ");
		System.out.println("3.- Saldo y movimientos");
		System.out.println("4.- Salir");
	}

}
