package service;

import java.util.ArrayList;
import java.util.Collections;

public class ListaNumeros extends ArrayList<Integer>{
	@Override
	public boolean add(Integer dato) {
		if(!contains(dato)) {
			return super.add(dato);
		}
		return false;
	}
	
	public void invertir() {
		/*int aux;
		int posUltimo=size()-1;
		for(int i=0;i<size()/2;i++){
		   aux=get(i);
		   set(i,get(posUltimo-i));
		   set(posUltimo-i,aux);
		}*/
		Collections.reverse(this);
	}
}
