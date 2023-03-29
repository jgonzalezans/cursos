package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Curso;

public class EscuelaService {
	String cadenaConexion="jdbc:mysql://localhost:3307/escuela";
	String user="root";
	String pwd="root";
	
	public Curso cursoDenominacion(String denominacion) {
		Curso curso=null;
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from cursos where denominacion=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, denominacion);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				curso=new Curso(rs.getInt("idCurso"),
						rs.getString("denominacion"),
						rs.getInt("duracion"),
						rs.getDouble("precio"),
						rs.getDate("fechaInicio").toLocalDate());
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return curso;
	}
	
	public Alumno alumnoDni(String dni) {
		Alumno alumno=null;
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			String sql="select * from alumnos where dni=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, dni);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				alumno=new Alumno(rs.getString("dni"),
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getString("email"),
						rs.getInt("curso"));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return alumno;
	}

	public boolean altaCurso(Curso curso) {
		//si ya hay un curso que tiene ese nombre, salimos
		if(cursoDenominacion(curso.getDenominacion())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="insert into cursos(denominacion,duracion,precio,fechaInicio) values(?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			//asignamos valores a los parámetros
			statement.setString(1, curso.getDenominacion());
			statement.setInt(2, curso.getDuracion());
			statement.setDouble(3, curso.getPrecio());
			statement.setDate(4, Date.valueOf(curso.getFechaInicio()));
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean altaAlumno(Alumno alumno, String denominacion) {
		//si ya hay una alumno con es DNI, salimos
		
		Curso curso=cursoDenominacion(denominacion);
		//si el curso no existe salimos
		if(alumnoDni(alumno.getDni())!=null||curso==null) {
			return false;
		}
		//actualizamos objeto alumno con su idCurso
		alumno.setCurso(curso.getIdCurso());
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="insert into alumnos(dni,nombre,edad,email,curso) values(?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			//asignamos valores a los parámetros
			statement.setString(1, alumno.getDni());
			statement.setString(2, alumno.getNombre());
			statement.setInt(3, alumno.getEdad());
			statement.setString(4, alumno.getEmail());
			statement.setInt(5, alumno.getCurso());
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public List<Alumno> buscarAlumnosCurso(String denominacion){
		ArrayList<Alumno> alumnos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="select alumnos.* from alumnos,cursos where cursos.denominacion=? and alumnos.curso=cursos.idCurso";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, denominacion);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getString("dni"),
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getString("email"),
						rs.getInt("curso")));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return alumnos;
		
	}
	
	public List<Curso> cursosPosterioresFecha(LocalDate fecha){
		ArrayList<Curso> cursos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="select * from cursos where fechaInicio>?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setDate(1, Date.valueOf(fecha));
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
						rs.getString("denominacion"),
						rs.getInt("duracion"),
						rs.getDouble("precio"),
						rs.getDate("fechaInicio").toLocalDate()));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cursos;
	}

	public boolean eliminarAlumno(String dni) {
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){		
			//con PrepareStatement
			String sql="delete from alumno where dni=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, dni);
			statement.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
