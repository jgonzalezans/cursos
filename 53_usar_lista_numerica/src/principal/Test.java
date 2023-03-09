package principal;

import service.ListaNumeros;

public class Test {

	public static void main(String[] args) {
		ListaNumeros lista=new ListaNumeros();
		lista.add(10);
		lista.add(30);
		lista.add(10);
		lista.add(5);
		lista.add(25);
		lista.invertir();
		for(int num:lista) {
			System.out.println(num);
		}
	}

}
