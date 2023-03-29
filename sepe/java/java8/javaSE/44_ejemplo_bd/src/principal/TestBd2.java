package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBd2 {

	public static void main(String[] args) {
		String cadenaConexion="jdbc:mysql://localhost:3307/agenda";
		String user="root";
		String pwd="root";
		//Creamos la conexión contra la base de datos
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from contactos";
			//envío instrucción SQL
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);			
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
