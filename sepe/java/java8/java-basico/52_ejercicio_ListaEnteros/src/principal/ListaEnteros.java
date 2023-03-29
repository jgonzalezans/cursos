package principal;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Desarrollar una clase llamada ListaEnteros, para crear listas de números enteros.
 * 
 * Tendrá todos los métodos de ArrayList, con las siguientes consideraciones:
 * 
 * - No se permite tener números repetidos
 * - Dispondrá de un método adicional, que devuelva la lista invertida
 * 
 * @author joseg
 *
 */

public class ListaEnteros extends ArrayList<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Añade elementos siempre y cuando no estén repetidos.
	 */
	@Override
    public boolean add(Integer e) {
		if(!this.contains(e))
        return super.add(e);
		else return false;
    }
	

	public void invertir() {
		Collections.reverse(this);
	}
	
}