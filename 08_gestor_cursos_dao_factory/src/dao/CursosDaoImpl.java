package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Curso;
import static helpers.ConnectionLocator.*;
public class CursosDaoImpl implements CursosDao {

	@Override
	public boolean existeCurso(int idCurso) {
		try(Connection con=getConnection()){//al tener importados los elementos estáticos, no necesitamos poner primero la clase
			String sql="select * from cursos where idCurso=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCurso);
			ResultSet rs=ps.executeQuery();
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean guardarCurso(Curso curso) {
		try(Connection con=getConnection()){
			//instrucción sql parametrizada, las interrogantes son parámetros
			String sql="insert into cursos (idCurso,curso,duracion,precio) values (?,?,?,?) ";
			//se crea el PreparedStatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getCurso());
			ps.setInt(3, curso.getDuracion());
			ps.setDouble(4, curso.getPrecio());
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public List<Curso> cursos() {
		List<Curso> cursos=new ArrayList<>();
		try(Connection con=getConnection()){
			String sql="select * from cursos";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("idCurso"),
							rs.getString("curso"),
							rs.getInt("duracion"),
							rs.getDouble("precio"),
							null//lista de alumnos nula
						));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cursos;
	}

	
}
