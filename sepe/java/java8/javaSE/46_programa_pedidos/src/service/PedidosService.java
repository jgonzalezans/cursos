package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidosService {
	String cadenaConexion="jdbc:mysql://localhost:3307/pedidos";
	String user="root";
	String pwd="root";
	
	public boolean altaPedido(Pedido pedido) {
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="insert into pedidos(producto,unidades,fecha,tienda) values(?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, pedido.getProducto());
			statement.setInt(2, pedido.getUnidades());
			statement.setDate(3, Date.valueOf(pedido.getFecha())); //se convierte LocalDate a java.sql.Date para poder guardarlo
			statement.setString(4, pedido.getTienda());
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Pedido> pedidos(){
		ArrayList<Pedido> pedidos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from pedidos";
			PreparedStatement statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				pedidos.add(new Pedido(rs.getInt("idPedido"),
						rs.getString("producto"),
						rs.getInt("unidades"),
						rs.getDate("fecha").toLocalDate(),
						rs.getString("tienda")));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return pedidos;
	}
}
