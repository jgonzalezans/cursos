package prueba;

public class Test {

	public static void main(String[] args) {
		Coche c1=new Coche("amarillo");
		Coche c2=new Coche("azul");
		System.out.println("color de c1 "+c1.getColor());
		System.out.println("color de c2 "+c2.getColor());
		System.out.println("creados de c1 "+c1.getCreados());
		System.out.println("creados de c2 "+c2.getCreados());
	}

}
