package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestBD {

	public static void main(String[] args) throws SQLException {

		String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String user = "root";
		String pwd = "root";
		//Creamos la conexión de la base de datos
		Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);
	}

}
