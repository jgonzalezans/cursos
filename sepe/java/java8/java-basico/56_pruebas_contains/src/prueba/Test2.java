package prueba;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<String> textos=new ArrayList<String>();
		agregar(new String("hola"),textos);
		agregar(new String("adios"),textos);
		agregar(new String("hola"),textos);
		agregar(new String("by"),textos);
		mostrar(textos);

	}
	
	static void agregar(String num, ArrayList<String> textos) {
		if(!textos.contains(num)) {
			textos.add(num);
		}
	}
	static void mostrar(ArrayList<String> textos) {
		for(String num:textos) {
			System.out.println(num);
		}
	}

}
