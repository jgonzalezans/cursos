package service;

import java.util.ArrayList;

public class ContactosService {
	// atributo donde guardamos los contactos
	ArrayList<String> contactos = new ArrayList<String>();

	public void add(String contacto) {
		contactos.add(contacto);
	}

	public boolean delete(String contacto) {
		return contactos.remove(contacto);
	}

	public String[] getAll() {
		return contactos.toArray(new String [contactos.size()]);
	}

	public boolean exist(String contacto) {
		return contactos.contains(contacto);
	}
	
	/**
	 * Obtiene el primero de los contactos con ese nombre ya que todavía no tenemos IDs
	 * @param contacto
	 * @return
	 */
	public String getByName(String contacto) {
		int posicion = contactos.indexOf(contacto);
		if (posicion > -1) {
			return contactos.get(posicion);
		}
		return null;
	}

}