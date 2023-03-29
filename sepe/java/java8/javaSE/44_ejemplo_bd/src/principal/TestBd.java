package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBd {

	public static void main(String[] args) {
		String cadenaConexion="jdbc:mysql://localhost:3307/agenda";
		String user="root";
		String pwd="root";
		//Creamos la conexión contra la base de datos
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="insert into contactos(nombre,email,numero) values('prueba2','prueba2@gmail.com',2345)";
			//envío instrucción SQL
			Statement st=con.createStatement();
			st.execute(sql);			
			System.out.println("Contacto añadido!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
