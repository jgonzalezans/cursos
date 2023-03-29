package service;

import java.util.HashMap;

import model.Contacto;

public class AgendaService {
	HashMap<Integer,Contacto> agenda=new HashMap<Integer, Contacto>();
	public boolean agregarContacto(int telefono, String nombre,int edad) {
		if(!agenda.containsKey(telefono)) {
			Contacto c2=new Contacto();
			Contacto contacto=new Contacto(nombre, telefono, edad);
			agenda.put(telefono, contacto);
			return true; //lo he podido añadir
		}
		return false; //no se ha podido añadir
	
		
	}
	public void eliminarContacto(int telefono) {
		agenda.remove(telefono);
	}
	public Contacto buscar(int telefono) {
		return agenda.get(telefono);
	}
	public Contacto[] recuperarTodos() {
		/*String[] nombres=new String[agenda.size()];
		Collection<String> valores=agenda.values();
		int cont=0;
		for(String nombre:valores) {
			nombres[cont]=nombre;
			cont++;
		}*/
		Contacto[] contactos=agenda.values().toArray(new Contacto[0]);
		return contactos;
	} 
}
