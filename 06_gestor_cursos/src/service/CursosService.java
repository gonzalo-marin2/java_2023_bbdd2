package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Curso;

public class CursosService {
	String cadenaCon="jdbc:mysql://localhost:3306/formacion";
	String user="root";
	String pwd="root";
	
	/*public List<Curso> cursos(){
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql="select * from formacion.cursos";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.execute(sql);
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}*/
	
	
}
