package tareas;

import java.util.List;

public class TareaAscendente extends Thread{
	
	private List<String> lista;
	
	

	public TareaAscendente(List<String> lista) {
		super();
		this.lista = lista;
	}



	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			lista.add("Ascendente: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
