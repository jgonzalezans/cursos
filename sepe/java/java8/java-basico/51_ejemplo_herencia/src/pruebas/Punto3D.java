package pruebas;

public class Punto3D {
	
	private int x,y;

	public Punto3D(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void dibujar() {
		System.out.println("Coordenadas: "+x+" , "+y);
	}
	

}
