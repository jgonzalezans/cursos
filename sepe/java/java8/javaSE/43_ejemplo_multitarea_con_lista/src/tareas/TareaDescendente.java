package tareas;

import java.util.List;

public class TareaDescendente extends Thread{
	private List<String> lista;
	
	public TareaDescendente(List<String> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void run() {
		for(int i=100;i>=1;i--) {
			lista.add("Descendente: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
