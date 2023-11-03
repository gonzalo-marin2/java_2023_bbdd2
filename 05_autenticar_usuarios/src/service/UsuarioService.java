package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioService {
	String cadenaCon="jdbc:mysql://localhost:3306/empresa";
	String user="root";
	String pwd="root";
	
	public boolean autenticar(Usuario usuario) {
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql="select * from usuarios where password=? and usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario.getPassword());
			ps.setString(2, usuario.getUsuario());
			ResultSet rs=ps.executeQuery();
			/*if(rs.next()){
			  return true;
			  } else {
			  return false
			  }*/
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Usuario getUsuario(String usuario) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="select * from usuarios where usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {//hay que mover el ResultSet
				return new Usuario(usuario,rs.getString("password"));
			}
			return null;		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
