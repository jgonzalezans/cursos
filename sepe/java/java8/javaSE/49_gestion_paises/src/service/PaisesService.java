package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pais;

public class PaisesService {
	String cadenaConexion="jdbc:mysql://localhost:3307/paisesBD";
	String user="root";
	String pwd="root";
	
	public Pais paisCapital(String capital) {
		Pais p = null;
		try(Connection con=DriverManager.getConnection(cadenaConexion,user,pwd);){
			String sql="Select * from paises WHERE capital=?";
			PreparedStatement statement;
			statement=con.prepareStatement(sql);
			statement.setString(1, capital);
			ResultSet rs=statement.executeQuery();
			//public Pais(String name, String capital, String region, long population) {
			if(rs.next()) {
				p=new Pais(rs.getInt("idpais"),
						rs.getString("nombre"),
						rs.getLong("poblacion"),
						rs.getString("capital"),
						rs.getString("continente")
						);

			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
	public List<Pais> paisesContinente(String continente){
		ArrayList<Pais> paises=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="SELECT * FROM paises WHERE continente=? ";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, continente);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				paises.add(new Pais(rs.getInt("idpais"),
						rs.getString("nombre"),
						rs.getLong("poblacion"),
						rs.getString("capital"),
						rs.getString("continente")
						));
			}

		}catch(SQLException ex) {
			ex.printStackTrace();

		}
		return paises;
	}
	public List<Pais> paisPoblacion(Long poblacion) {
		ArrayList<Pais> paises = new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion,user,pwd);){
			String sql="Select * from paises WHERE poblacion<?";
			PreparedStatement statement;
			statement=con.prepareStatement(sql);
			statement.setLong(1, poblacion);
			ResultSet rs=statement.executeQuery();
			//public Pais(String name, String capital, String region, long population) {
			while(rs.next()) {
				paises.add(new Pais(rs.getInt("idpais"),
						rs.getString("nombre"),
						rs.getLong("poblacion"),
						rs.getString("capital"),
						rs.getString("continente")
						));

			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return paises;

	}
}
