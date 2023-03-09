package service;

import java.util.HashMap;

public class ContactosService {

	HashMap<Integer, String> agenda = new HashMap<Integer, String>();

	public void add(String contacto, Integer telefono) {
		if(!exist(telefono))
		agenda.put(telefono, contacto);
	}

	public void delete(int telefono) {
		agenda.remove(telefono);
	}
	
	public String get(int telefono) {		
		return agenda.get(telefono);		
	}

	public String[] getAll() {
		return agenda.values().toArray(new String [agenda.values().size()]);
	}

	public boolean exist(int telefono) {
		return agenda.containsKey(telefono);
	}

}