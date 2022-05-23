package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	protected Connection con = null;

	public void conectar() throws SQLException {
		String db = "memorion";
		String password = "";
		String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/" + db;
		System.out.println("---------------------------------------------------------");

		con = DriverManager.getConnection(url, usuario, password);
	}
}
