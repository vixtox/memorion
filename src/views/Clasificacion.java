package views;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.DbMemorion;
import modelo.Score;

public class Clasificacion extends GridPane{
	
	private ArrayList<Label> arrayLabel;
	private Button bGoMenu;
	
	public Clasificacion() throws SQLException, FileNotFoundException {
		DbMemorion m = new DbMemorion();
		ArrayList<Score> listaScores = m.getTopScores();
		this.arrayLabel = new ArrayList<Label>();
		
		for (int i = 0; i < listaScores.size(); i ++) {
			this.arrayLabel.add(new Label((i + 1) + ". " + listaScores.get(i).toString()));
			setDesignLabel(this.arrayLabel.get(i));
			this.add(this.arrayLabel.get(i), 0, i);
		}
	
		this.bGoMenu = new Button("Go Menu");
		MenuMemorion menuMemorion = new MenuMemorion();
		menuMemorion.setDesignButton(this.bGoMenu, 1400, 100);
		this.add(bGoMenu, 0, 10);
		
		this.setStyle("-fx-background-color: Black;");
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(50));
	}
	
	public void setDesignLabel(Label label) {
		label.setFont(new Font("Times New Roman",70));
		label.setTextFill(Color.YELLOW);
	}

	public ArrayList<Label> getArrayLabel() {
		return arrayLabel;
	}

	public void setArrayLabel(ArrayList<Label> arrayLabel) {
		this.arrayLabel = arrayLabel;
	}

	public Button getbGoMenu() {
		return bGoMenu;
	}

	public void setbGoMenu(Button bGoMenu) {
		this.bGoMenu = bGoMenu;
	}

}
