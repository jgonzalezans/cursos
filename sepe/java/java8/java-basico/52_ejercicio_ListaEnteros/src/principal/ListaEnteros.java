package principal;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Desarrollar una clase llamada ListaEnteros, para crear listas de n�meros enteros.
 * 
 * Tendr� todos los m�todos de ArrayList, con las siguientes consideraciones:
 * 
 * - No se permite tener n�meros repetidos
 * - Dispondr� de un m�todo adicional, que devuelva la lista invertida
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
	 * A�ade elementos siempre y cuando no est�n repetidos.
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