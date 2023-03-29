package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Item;

public class BuscadorService {
	public Set<Item> buscador(List<Item> items, String tematica) {
		//guardamos resultados encontrados
		HashSet<Item> resultados=new HashSet<Item>();
		//recorremos la lista de items y aquellos que sean de la temática recibida
		//se guardarán en el conjunto de resultados
		for(Item item:items) {
			if(item.getTematica().equals(tematica)) {
				resultados.add(item);
			}
		}
		return resultados;
	}
}
