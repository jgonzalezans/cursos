package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

public class PaisesService {
	
	String dir="c:\\tempo\\ciudades.txt";
	Path path=Path.of(dir);
	Pais[] paises;
	
	public PaisesService() {
	Gson gson=new Gson();
	try {
		paises=gson.fromJson(new FileReader(dir), Pais[].class);
	} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	//lista con los nombres de todos los paises
	public List<String> getNombresPaises(){
		return Arrays.stream(paises)
		.map(p->p.getRegion()) //Stream<String> nombres
		.distinct() //Stream<String> sin duplicados
		.collect(Collectors.toList());  //List<String>
		
	}
	//población total del continente cuyo nombre se recibe como parámetro
	
	//lista de paises del continente cuyo nombre se recibe como parámetro
	
	//pais más poblado
	
}
