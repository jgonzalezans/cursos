package tareas;

public class TareaDescendente extends Thread{

	@Override
	public void run() {
		for (int i = 100; i >= 100; i--) {
			System.out.println("Descendente: "+i);
		}
	}
	
	

}
