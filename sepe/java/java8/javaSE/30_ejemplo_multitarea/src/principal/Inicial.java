package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Inicial {

	public static void main(String[] args) {

		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
		
		ta.start();
		td.start();
	}

}
