package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

public class TestGson {

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		String ruta="c:\\tempo\\empleados.json";
		Gson gson=new Gson();
		Empleado[] empleados=gson.fromJson(new FileReader(ruta), Empleado[].class);
		for(Empleado emp:empleados) {
			System.out.println(emp.getNombre());
		}
	}

}
