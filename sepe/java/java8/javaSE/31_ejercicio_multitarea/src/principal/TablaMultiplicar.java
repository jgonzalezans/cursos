package principal;

import java.util.ArrayList;
import java.util.List;

import task.MultiplicarTask;
import task.PedirNumeroTask;

public class TablaMultiplicar {
	
	public static int maxNums = 5;
	public static List<Integer> numerosRecogidos = new ArrayList<>();

	public static void main(String[] args) {

		
		for (int i = 0; i <maxNums; i++) {
			PedirNumeroTask pedirNumeroTask = new PedirNumeroTask();
			pedirNumeroTask.run();
			
		}
		
		for (Integer num : numerosRecogidos) {
			MultiplicarTask m = new MultiplicarTask(num);
			m.start();
			
		}
		//numerosRecogidos.forEach(n->System.out.println(n));
	}

}
