package principal;

public class IgualdadTextos2 {

	public static void main(String[] args) {
		//Da iguales porque reutiliza el texto en memoria al no hacer un new
		String s1 = "hola";
		String s2 = "hola";
		if (s1 == s2) {
			System.out.println("iguales");
		} else {
			System.out.println("distintos");
		}
	}

}
