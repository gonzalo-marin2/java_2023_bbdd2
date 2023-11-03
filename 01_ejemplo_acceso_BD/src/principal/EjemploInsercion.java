package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsercion {

	public static void main(String[] args) {
		//Nos ahorramos el paso 1
		//Paso 2:Establecimiento de la conexión
		//Datos de conexión
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
		//creamos un objeto Connection(es una interfaz)
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			//Ejecución de la sentencia sql(Paso 3)
			String sql="insert into empleados (nombre,email,departamento,salario) ";
			sql+="values('paco','paco@mail.com','informática', 1600)";
			Statement st=con.createStatement();//Creamos el objeto Statement
			st.execute(sql);//ejecutamos la sentencia sql
			System.out.println("Empleado añadido!!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error de conexión");
		}
		
		//con.close();//cerramos la conexión, con el try con recursos, nos ahorramos el cierre de objetos
		//Objetos que se crean en el paréntesis del try, se cierran solos

	}

}
