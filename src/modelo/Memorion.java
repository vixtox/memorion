package modelo;

public class Memorion {
	
	private int countParejas;
	
	public Memorion() {
		this.countParejas = 0;
	}
	
	public boolean checkMove(String id1, String id2) {
		if (id1.equals(id2)) {
			countParejas++;
			return true;
		}
		
		return false;
	}
	
	public boolean endGame() {
		if (countParejas == 10)
			return true;
		
		return false;
	}

}
