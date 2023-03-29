package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class AgendaService {

	String cadenaConexion = "jdbc:mysql://localhost:3307/agenda";
	String user = "root";
	String pwd = "root";

	public boolean agregarContacto(String nombre, String email, int numero) {
		// Creamos la conexión contra la base de datos
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);) {
			// con Statement
			/*
			 * String
			 * sql="insert into contactos(nombre,email,numero) values('"+nombre+"','"+email+
			 * "',"+numero+")"; //envío instrucción SQL Statement st=con.createStatement();
			 * st.execute(sql); return true;
			 */
			// con PrepareStatement
			String sql = "insert into contactos(nombre,email,numero) values(?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			// asignamos valores a los parámetros
			statement.setString(1, nombre);
			statement.setString(2, email);
			statement.setInt(3, numero);
			statement.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean eliminarContacto(String email) {
		// Se crea la conexión contra la base de datos
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);) {
			/*
			 * String sql = "delete from contactos where email='"+email+"'"; // envío de la
			 * instrucción SQL Statement st = con.createStatement(); st.execute(sql);
			 */
			String sql = "delete from contactos where email=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.execute();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public List<Contacto> recuperarContactos() {

		List<Contacto> contactos = new ArrayList<>();
		// Se crea la conexión contra la base de datos
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);) {

			// envío de la instrucción SQL

			String sql = "select * from contactos";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {

				Contacto contacto = new Contacto(
						result.getInt("idContacto"),
						result.getString("nombre"),
						result.getString("email"), 
						result.getInt("numero"));

				contactos.add(contacto);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return contactos;
	}


	//añade todos los contactos de la lista a la BD
	public boolean agregarContactos(List<Contacto> contactos) {
		contactos.forEach(c-> agregarContacto(c.getNombre(), c.getEmail(), c.getNumero()));
		return true;
		//		for (Contacto contacto : contactos) {
		//			agregarContacto(contacto.getNombre(), contacto.getEmail(), contacto.getNumero());
		//		}
	}
	//recupera el contacto por su id. Si no existe, devuelve null
	public Contacto buscarContacto(int idContacto) {

		return recuperarContactos().stream()
				.filter(c-> c.getIdContacto() == idContacto)
				.findFirst()
				.orElse(null);

	}
}
