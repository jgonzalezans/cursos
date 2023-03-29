package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class AgendaService {
	String cadenaConexion="jdbc:mysql://localhost:3307/agenda";
	String user="root";
	String pwd="root";
	
	public boolean agregarContacto(String nombre, String email, int numero) {
		//Creamos la conexión contra la base de datos
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			//con Statement
			/*String sql="insert into contactos(nombre,email,numero) values('"+nombre+"','"+email+"',"+numero+")";
			//envío instrucción SQL
			Statement st=con.createStatement();
			st.execute(sql);			
			return true;*/
			//con PrepareStatement
			String sql="insert into contactos(nombre,email,numero) values(?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			//asignamos valores a los parámetros
			statement.setString(1, nombre);
			statement.setString(2, email);
			statement.setInt(3, numero);
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarContacto(String email) {
		// Se crea la conexión contra la base de datos
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);){
			/*String sql = "delete from contactos where email='"+email+"'";
			// envío de la instrucción SQL
			Statement st = con.createStatement();
			st.execute(sql);*/
			String sql = "delete from contactos where email=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, email);
			statement.execute();
			return true;

		} catch (SQLException ex){
			ex.printStackTrace();
			return false;
		}
	
	}
	
	
	public List<Contacto> recuperarContactos() {
		ArrayList<Contacto> contactos=new ArrayList<>();
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from contactos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Contacto contacto=new Contacto(rs.getInt("idContacto"), 
						rs.getString("nombre"), 
						rs.getString("email"), 
						rs.getInt("numero"));
				contactos.add(contacto);
			}

		} catch (SQLException ex){
			ex.printStackTrace();
			
		}
		return contactos;
	}
	//añade todos los contactos de la lista a la BD
	public boolean agregarContactos(List<Contacto> contactos) {
		boolean res=true;
		/*try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			
			//con PrepareStatement
			String sql="insert into contactos(nombre,email,numero) values(?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			for(Contacto c:contactos) {
				statement.setString(1, c.getNombre());
				statement.setString(2, c.getEmail());
				statement.setInt(3, c.getNumero());
				statement.execute();
			}
			//asignamos valores a los parámetros
			
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}*/
		
		//pensar en una alternativa que reutilice el agregarContacto
		for(Contacto contacto:contactos) {
			res=res&&agregarContacto(contacto.getNombre(), contacto.getEmail(),contacto.getNumero());
		}
		//devolvemos true si todos los contactos se han podido añadir, y false si alguno de ellos
		//no se ha añadido
		return res;
		
	}
	//recupera el contacto por su id. Si no existe, devuelve null
	public Contacto buscarContacto(int idContacto) {
		Contacto contacto=null;
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from contactos where idcontacto=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idContacto);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				contacto=new Contacto(rs.getInt("idContacto"), 
						rs.getString("nombre"), 
						rs.getString("email"), 
						rs.getInt("numero"));
			}

		} catch (SQLException ex){
			ex.printStackTrace();
			
		}
		return contacto;
	}
	
	
	
	
	
	
	
}
