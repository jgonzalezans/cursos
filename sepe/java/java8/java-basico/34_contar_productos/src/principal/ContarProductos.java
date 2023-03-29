package principal;

public class ContarProductos {

	public static void main(String[] args) {
		String productos="pelota, pan, agua, pan,vino, pelota, pan,leche,papel ,pan,vino";
		String[] datos=productos.split(",");
		/*
		 voy a recorrer el array y, para cada elemento del mismo, compruebo si ya lo he recorrido
		 ese producto, si no, entonces cuento cuantas veces aparece en el array
		 */
		for(int i=0;i<datos.length;i++) {
			if(!comprobarSiRecorrido(i,datos)) {
				System.out.println(datos[i]+" aparece "+contador(datos[i],datos)+" veces");
			}
		}		
	}
	
	static boolean comprobarSiRecorrido(int pos, String[] cadenas) {
		boolean resultado=false;
		for(int i=0;i<pos;i++) {
			if(cadenas[pos].trim().equals(cadenas[i].trim())) {
				resultado=true;
				break; //si hemos encontrado repetición, abandonamos el for
			}
		}
		return resultado;
	}
	
	static int contador(String producto,String[] cadenas) {
		int cont=0;
		for(String cad:cadenas) {
			if(cad.trim().equals(producto.trim())) {
				cont++;
			}
		}
		return cont;
	}

}
