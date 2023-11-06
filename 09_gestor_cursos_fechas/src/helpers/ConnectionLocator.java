package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLocator {
	static String cadenaCon="jdbc:mysql://localhost:3306/formacionfechas";
	static String user="root";
	static String pwd="root";
	
	public static Connection getConnection() throws SQLException {//el try/catch se hará en el método que lo llame
		return DriverManager.getConnection(cadenaCon,user,pwd);
	}

}
