package principal;

import java.util.ArrayList;

import model.Alumno;

public class Test {

	public static void main(String[] args) {
		ArrayList<Alumno> lista=new ArrayList<Alumno>();
		//creamos dos alumnos y los guardamos en el arraylist
		Alumno a1=new Alumno("pepe","2222",45);
		/*a1.setNombre("pepe");
		a1.setDni("2222");
		a1.setEdad(45);*/
		Alumno a2=new Alumno("ana","1111",54);
		/*a2.setNombre("ana");
		a2.setDni("1111");;
		a2.setEdad(54);*/
		lista.add(a1);
		lista.add(a2);
		
		//recuperar un objeto alumno
		Alumno alumno=lista.get(1);

	}

}
