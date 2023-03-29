package service;

import java.util.Collection;
import java.util.HashMap;

public class AgendaService {
	HashMap<Integer,String> agenda=new HashMap<Integer, String>();
	public boolean agregarContacto(int telefono, String nombre) {
		if(!agenda.containsKey(telefono)) {
			agenda.put(telefono, nombre);
			return true; //lo he podido añadir
		}
		return false; //no se ha podido añadir
	
		
	}
	public void eliminarContacto(int telefono) {
		agenda.remove(telefono);
	}
	public String buscar(int telefono) {
		return agenda.get(telefono);
	}
	public String[] recuperarTodos() {
		/*String[] nombres=new String[agenda.size()];
		Collection<String> valores=agenda.values();
		int cont=0;
		for(String nombre:valores) {
			nombres[cont]=nombre;
			cont++;
		}*/
		String[] nombres=agenda.values().toArray(new String[0]);
		return nombres;
	} 
}
