package test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import service.CadenasService;

public class TestCadenas {

	public static void main(String[] args) {
		List<String> nombres = List.of("amapola", "procesando", "ana", "composicion", "ver", "adios");
		CadenasService service = new CadenasService();

//mostrar la longitud de las cadenas que empiezan por "a"
		System.out.println("mostrar la longitud de las cadenas que empiezan por \"a\"");
		service.procesarCadenas(nombres, new Mostrar(), new Longitud(), new EmpezarA());

//mostrar el total de vocales de las cadenas que tengan más de cinco caracteres
		System.out.println("mostrar el total de vocales de las cadenas que tengan más de cinco caracteres");
		service.procesarCadenas(nombres, new Mostrar(), new Vocales(), new MayorCinco());
	}

}

class Mostrar implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}
}

class EmpezarA implements Predicate<String> {
	@Override
	public boolean test(String t) {
		return t.toLowerCase().startsWith("a");
	}
}

class MayorCinco implements Predicate<String> {
	@Override
	public boolean test(String t) {
		return t.length() > 5;
	}
}

class Longitud implements Function<String, Integer> {
	@Override
	public Integer apply(String t) {
		return t.length();
	}
}

class Vocales implements Function<String, Integer> {
	@Override
	public Integer apply(String t) {
		int total = 0;
		for (int i = 0; i < t.length(); i++) {
			switch (t.toLowerCase().charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				total++;
			}
		}
		return total;
	}
}