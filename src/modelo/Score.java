package modelo;

public class Score {
	
	private int id;
	private String name;
	private int intentos;
	private String fecha;
	
	public Score(int id, String name, int intentos, String fecha) {
		this.id = id;
		this.name = name;
		this.intentos = intentos;
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return name + "\t\t" + intentos + "\t\t" + fecha + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
