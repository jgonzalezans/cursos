package principal;
//lanzar el dado un número determinado de veces e indicar el porcentaje de cada tirada
public class Dados {

	public static void main(String[] args) {
		final int tiradas=100000;
		int [] contadores=new int[6];
		int dado;
		for(int i=1;i<=tiradas;i++) {
			dado=(int)(Math.random()*6+1);
			//si es un 1, incrementamos contador 0, si es un 2, contador 1,....
			contadores[dado-1]++;
		}

		//mostramos los porcentajes
		for(int i=0;i<contadores.length;i++) {
			System.out.println("Procetaje de "+(i+1)+" es: "+(contadores[i]*100/tiradas)+"%");
		}
	}

}
