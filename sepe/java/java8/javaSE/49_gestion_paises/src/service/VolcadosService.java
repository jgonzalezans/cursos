package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;

import model.Pais;

public class VolcadosService {
	String cadenaConexion="jdbc:mysql://localhost:3307/paisesBD";
	String user="root";
	String pwd="root";
	String urlService="https://restcountries.com/v2/all";
	
	private Pais[] paises() {
		Gson gson=new Gson();
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(urlService)) //Builder
							.GET() //Builder
							.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
						.version(Version.HTTP_1_1)
						.build();
		//lanzar petición y objeto HttpResponse

		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			return gson.fromJson(response.body().toString(), Pais[].class);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Pais[0];
		}
	}
	private void borrarTabla() {
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="delete from paises";
			PreparedStatement statement=con.prepareStatement(sql);		
			statement.execute();		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void actualizarBD() {
		borrarTabla();
		Pais[] paises=paises();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			con.setAutoCommit(false);
			//con PrepareStatement
			String sql="insert into paises(nombre,poblacion,capital,continente) values(?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			for(Pais pais:paises) {
				//asignamos valores a los parámetros
				statement.setString(1, pais.getNombre());
				statement.setLong(2, pais.getPoblacion());
				statement.setString(3, pais.getCapital());
				statement.setString(4, pais.getContinente());
				statement.execute();
			}
			con.commit();
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}
}
