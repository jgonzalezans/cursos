package principal;
//dado un grupo de notas existentes en una cadena de caracteres, calcular la nota media
public class CalculoNotas {

	public static void main(String[] args) {
		String cadena="5.6,8.9,6.7,3.2,6.3,7.5";
		double media=0;
		String[] notas=cadena.split(",");
		for(String nota:notas) {
			media+=Double.parseDouble(nota);
		}
		System.out.println("La nota media es: "+media/notas.length);
		System.out.printf("La nota media es %.2f",media/notas.length);
	}

}
