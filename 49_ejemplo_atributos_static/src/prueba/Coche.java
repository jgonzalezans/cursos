package prueba;

public class Coche {
	private String color; //cada objeto tiene su copia
	private static int creados; //todos los objetos comparten la misma copia
	
	public Coche (String color) {
		this.color=color;
		creados++;
	}
	public String getColor() {
		return color;
	}
	public int getCreados() {
		return creados;
	}
	
}
