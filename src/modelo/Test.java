package modelo;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		DbMemorion b;
		try {
			b = new DbMemorion();
			b.conectar();
			System.out.println("Conexión a base de datos correcta.");	
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
