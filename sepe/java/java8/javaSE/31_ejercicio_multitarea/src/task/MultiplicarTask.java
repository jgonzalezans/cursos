package task;

public class MultiplicarTask extends Thread {

	int numero;

	public MultiplicarTask(Integer num) {

		numero = num;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.println("Multiplicando el número: " + numero + " x " + i +" = "+numero*i);

		}
	}

}
