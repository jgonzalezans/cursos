package principal;

//dado un número decimal que se encuentra almacenado como texto,
//hacer un programa que nos muestre la parte entera y decimal del número
public class Comprobar {

	public static void main(String[] args) {
		String num="1245,983";
		//pistas: hay que utilizar indexOf y substring
		int posDecimal=num.indexOf(",");
		System.out.println("Parte entera: "+num.substring(0,posDecimal));
		System.out.println("Parte decimal: "+num.substring(posDecimal+1, num.length()));
		System.out.println("Parte decimal: "+num.substring(posDecimal+1));
	}

}
