package principal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Inicial {

	public static void main(String[] args) {
		List<String> lista=new CopyOnWriteArrayList<>(); //thread safe
		TareaAscendente ta=new TareaAscendente(lista);
		TareaDescendente td=new TareaDescendente(lista);
		ta.start();		
		td.start();
		
		/*for(int i=1;i<=100;i++) {
			System.out.println("otras cossas del main: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

}
