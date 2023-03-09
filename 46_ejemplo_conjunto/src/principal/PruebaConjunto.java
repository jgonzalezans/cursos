package principal;

import java.util.HashSet;

public class PruebaConjunto {

	public static void main(String[] args) {
		
		HashSet<String> dias=new HashSet<String>();
		dias.add("lunes");
		dias.add("martes");
		dias.add("miercoles");
		dias.add("jueves");
		dias.add("lunes");
		for(String dia:dias) {
			System.out.println(dia);
		}
	}

}
