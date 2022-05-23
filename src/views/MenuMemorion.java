package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuMemorion extends AnchorPane{

	private Button bBanderas, bEscudos, bAnimales, bBolaDragon, bHarryPotter, bJugadoresBetis;
	
	public MenuMemorion() throws FileNotFoundException{
		
		this.bBanderas = new Button("Banderas países");
		setDesignButton(this.bBanderas,400,80);
		
		this.bEscudos = new Button("Escudos fútbol");
		setDesignButton(this.bEscudos,400,80);
		
		HBox hbox = new HBox(this.bBanderas,this.bEscudos);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(100);
		
		this.bAnimales = new Button("Fotos animales");
		setDesignButton(this.bAnimales,400,80);
		
		this.bBolaDragon = new Button("Bola de dragón");
		setDesignButton(this.bBolaDragon,400,80);
		
		HBox hbox2 = new HBox(this.bAnimales,this.bBolaDragon);
		hbox2.setSpacing(100);
		
		this.bHarryPotter = new Button("Harry Potter");
		setDesignButton(this.bHarryPotter,400,80);
		
		this.bJugadoresBetis = new Button("Jugadores Betis");
		setDesignButton(this.bJugadoresBetis,400,80);
		
		
		HBox hbox3 = new HBox(this.bHarryPotter,this.bJugadoresBetis);
		hbox3.setSpacing(100);
		
		VBox vbox = new VBox(hbox,hbox2,hbox3);
		vbox.setSpacing(100);

		this.getChildren().add(vbox);
		vbox.setLayoutX(500);
		vbox.setLayoutY(400);
		

		FileInputStream input = new FileInputStream("img/portada.jpg");
		Image image = new Image(input);
		this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	}
	
	public void setDesignButton(Button button, double width, double heigth) {
		button.setMinSize(width, heigth);
        button.setFont(new Font("Times New Roman",48));
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        hoverMouse(button,"GREEN");
	}

	public void hoverMouse(Button btn, String color) {
		final DropShadow shadowBotton = new DropShadow();
		shadowBotton.setColor(Color.valueOf(color));
		// Poner sombra cuado pase el cursor
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> btn.setEffect(shadowBotton));
		// Quitar sombra cuando se quite el cursor
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, e -> btn.setEffect(null));
	}
	
	public Button getbBanderas() {
		return bBanderas;
	}

	public void setbBanderas(Button bBanderas) {
		this.bBanderas = bBanderas;
	}

	public Button getbEscudos() {
		return bEscudos;
	}

	public void setbEscudos(Button bEscudos) {
		this.bEscudos = bEscudos;
	}

	public Button getbAnimales() {
		return bAnimales;
	}

	public void setbAnimales(Button bAnimales) {
		this.bAnimales = bAnimales;
	}

	public Button getbBolaDragon() {
		return bBolaDragon;
	}

	public void setbBolaDragon(Button bBolaDragon) {
		this.bBolaDragon = bBolaDragon;
	}

	public Button getbHarryPotter() {
		return bHarryPotter;
	}

	public void setbHarryPotter(Button bHarryPotter) {
		this.bHarryPotter = bHarryPotter;
	}

	public Button getbJugadoresBetis() {
		return bJugadoresBetis;
	}

	public void setbJugadoresBetis(Button bJugadoresBetis) {
		this.bJugadoresBetis = bJugadoresBetis;
	}
	
}
