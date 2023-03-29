package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoService {
	String cadenaConexion="jdbc:mysql://localhost:3307/banco";
	String user="root";
	String pwd="root";
	//implementar transaccionalidad a nivel de método
	
	public void transaccion(int cuentaOrigen, int cuentaDestino, double cantidad) {
		try (Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			//desactivar el autoconmit y se produce el inicio de transacción
			con.setAutoCommit(false);
			
			String sql1="update cuentas set saldo=saldo+? where numCuenta=?";
			String sql2="update cuentas set saldo=saldo-? where numCuenta=?";
			String sql3="insert into movimientos(cantidad,tipo) values(?,?)";
			PreparedStatement st1=con.prepareStatement(sql1);
			PreparedStatement st2=con.prepareStatement(sql2);
			PreparedStatement st3=con.prepareStatement(sql3);
			//asignamos valores a parámetros
			
			st1.execute();
			st2.execute();
			st3.execute();
			con.commit(); //confirmamos transacción
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}
}
