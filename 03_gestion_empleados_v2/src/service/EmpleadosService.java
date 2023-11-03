package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class EmpleadosService {
	String cadenaCon="jdbc:mysql://localhost:3306/empresa";
	String user="root";
	String pwd="root";

	public boolean altaEmpleado(Empleado empleado) {
		
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			//Ejecución de la sentencia sql(Paso 3)
			/*String sql="insert into empleados (nombre,email,departamento,salario) ";
			sql+="values( '"+empleado.getNombre()+"','"+empleado.getEmail()+"','"+empleado.getDepartamento()+"','"+empleado.getSalario()+"')";
			Statement st=con.createStatement();//Creamos el objeto Statement
			st.execute(sql);//ejecutamos la sentencia sql
			return true;*/
			
			//Opción con PreparedStatement
			//instrucción sql parametrizada, las interrogantes son parámetros
			String sql="insert into empleados (nombre,email,departamento,salario) values (?,?,?,?) ";
			//se crea el PreparedStatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getEmail());
			ps.setString(3, empleado.getDepartamento());
			ps.setDouble(4, empleado.getSalario());
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}	
	}
	
	//eliminar empleados por email
	
	public boolean eliminarEmpleado(String email) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="delete from empleados where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//modificar salario de empleado: se recibe el idEmpleado y el nuevo salario
	public boolean modificarSalario(double nuevoSalario, int idEmpleado) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="update empleados set salario=? where idEmpleado=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, nuevoSalario);
			ps.setInt(2, idEmpleado);
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//Agregar un método que nos permita buscar empleados por departamento. Recibe un departamento por parámetro
	public List<Empleado> empleadosPorDepartamento(String dep) {
		List<Empleado> empleados=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="select * from empleados where departamento=?";
			PreparedStatement ps=con.prepareStatement(sql);//al meter aquí la consulta sql, no hace falta que la pongamos después
			ps.setString(1, dep);
			ResultSet rs=ps.executeQuery();//no hace falta pasar la consulta sql, se ha pasado en el PreparedStatement
			while(rs.next()) {
				empleados.add(new Empleado(rs.getInt("idEmpleado"),
						rs.getString("nombre"),
						rs.getString("email"),
						rs.getString("departamento"),
						rs.getDouble("salario")
						));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return empleados;
	}
		
}
