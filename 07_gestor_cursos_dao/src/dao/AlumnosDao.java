package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;

public class AlumnosDao {
	String cadenaCon="jdbc:mysql://localhost:3306/formacion";
	String user="root";
	String pwd="root";
	
	public boolean existeAlumno(String dni) {
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql="select * from alumnos where dni=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs=ps.executeQuery();
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean guardarAlumno(Alumno alumno) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			//instrucción sql parametrizada, las interrogantes son parámetros
			String sql="insert into alumnos (dni,nombre,edad,nota,curso) values (?,?,?,?,?) ";
			//se crea el PreparedStatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, alumno.getDni());
			ps.setString(2, alumno.getNombre());
			ps.setInt(3, alumno.getEdad());
			ps.setDouble(4, alumno.getNota());
			ps.setInt(5, alumno.getCurso());
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//PARA GUARDAR DE GOLPE MUCHOS ALUMNOS
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			//instrucción sql parametrizada, las interrogantes son parámetros
			String sql="insert into alumnos (dni,nombre,edad,nota,curso) values (?,?,?,?,?) ";
			//se crea el PreparedStatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			for(Alumno alumno:alumnos) {
				//sustituimos parámetros por valores
				ps.setString(1, alumno.getDni());
				ps.setString(2, alumno.getNombre());
				ps.setInt(3, alumno.getEdad());
				ps.setDouble(4, alumno.getNota());
				ps.setInt(5, alumno.getCurso());
				ps.execute();
			}
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public List<Alumno> alumnos() {
		List<Alumno> alumnos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="select * from alumnos";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getString("dni"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getDouble("nota"),
							rs.getInt("curso")));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return alumnos;
	}
	
	public List<Alumno> alumnos(int curso) {
		List<Alumno> alumnos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="select * from alumnos where curso=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, curso);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getString("dni"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getDouble("nota"),
							rs.getInt("curso")));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return alumnos;
	}
}
