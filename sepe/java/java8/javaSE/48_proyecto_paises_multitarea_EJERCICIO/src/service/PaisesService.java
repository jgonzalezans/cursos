package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import model.Pais;

public class PaisesService {

	static String ruta="https://restcountries.com/v2/all";
	static Pais[] paises;


	//TODO: Esto debería ir en un DAO y todo lo de BD...
	String cadenaConexion="jdbc:mysql://localhost:3306/paises";
	String user="root";
	String pwd="root";


	//Sustituir constructor por bloque static para que solo se ejecute 1 vez a lo largo de todo el programa.

	static {
		Gson gson=new Gson();
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
				.uri(URI.create(ruta)) //Builder
				.GET() //Builder
				.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
				.version(Version.HTTP_1_1)
				.build();
		//lanzar petición y objeto HttpResponse
		try {
			final HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			paises=gson.fromJson(response.body().toString(), Pais[].class);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene la lista de paises y lo devuelve en un List<Pais> 
	 *  
	 * @return {@link List}<Pais>
	 */
	public List<Pais> getPaises(){
		return Arrays.asList(paises);
	}


	public boolean addPais(Pais pais) {

		//si ya hay un pais que tiene ese nombre, salimos
		//TODO:Lo actualizamos.
		if(nombrePais(pais.getNombre())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="insert into paises(nombre,poblacion,capital,continente) values(?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			//asignamos valores a los parámetros
			statement.setString(1, pais.getNombre());
			statement.setLong(2, pais.getPoblacion());
			statement.setString(3, pais.getCapital());
			statement.setString(4, pais.getContinente());
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private Pais nombrePais(String nombre) {
		Pais pais=null;
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from paises where nombre=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				pais=new Pais(
						rs.getInt("idpais"),
						rs.getString("nombre"),
						rs.getLong("poblacion"),
						rs.getString("capital"),
						rs.getString("continente"));
			}

		}catch(SQLException ex) {
			ex.printStackTrace();

		}
		return pais;
	}
}
