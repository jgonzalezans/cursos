package principal;

public class MostrarDecimalEntero {

	public static void main(String[] args) {

		String s = "1234,45";

		int posComa = s.indexOf(",");

		System.out.println("La parte entera de tu n�mero es : " + s.substring(0, posComa));
		System.out.println("La parte decimal de tu n�mero es : " + s.substring(posComa + 1));
	}

}