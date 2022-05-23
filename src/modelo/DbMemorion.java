package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbMemorion extends Conexion {

	private Statement stm = null;

	public DbMemorion() throws SQLException {
		this.conectar();
	}
	
	public void addScore(Score score) throws SQLException {
		stm = this.con.createStatement();
		
		String valores = "0,'" + score.getName() + "'," + score.getIntentos() + ",'" + score.getFecha() + "'";
		String sql = "insert into clasificacion values(" + valores + ")";
		
		
		stm.execute(sql);
	}
	
	public ArrayList<Score> getTopScores() throws SQLException {
		ArrayList<Score> topScores = new ArrayList<Score>();
		String sql = "select * from clasificacion order by intentos limit 10";
		stm = this.con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int intentos = rs.getInt(3);
			String fecha = rs.getString(4);
			
			topScores.add(new Score(id,name,intentos,fecha));
		}
		
		return topScores;
	}

}
