package principal;
//Hacer un programa que calcule la media de todos los números del array, que sean mayores que la variable a
public class MediaMayores {

	public static void main(String[] args) {
		int [] datos={8,-4,8,11,34,20,-2};
		int a=15;
		double media=0;
		int contador=0;
		/*for(int i=0;i<datos.length;i++) {
			if(datos[i]>a) {
				//media+=datos[i];
				media=media+datos[i];
				contador++;
			}
		}*/
		
		//el for anterior, pero como enhanced for
		for(int n:datos) {
			if(n>a) {
				media=media+n;
				contador++;
			}
		}
		media=media/contador;
		System.out.println("La media de los números es: "+media);
	}

}
