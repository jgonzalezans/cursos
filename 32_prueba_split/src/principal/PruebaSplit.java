package principal;
/**
 * ¿Cuántos nombres hay?
 * @author joseg
 *
 */

public class PruebaSplit {

	public static void main(String[] args) {

		String nombres = "Paco,Alicia,Marta.Pepe";
		String[] datos = nombres.split("[.,]");
		System.out.println(datos.length);
	}

}
