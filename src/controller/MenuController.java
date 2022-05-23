package controller;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import views.MenuMemorion;
import views.Tablero;

public class MenuController implements EventHandler<ActionEvent>{
	
	private MenuMemorion menuMemorion;
	private Button bBanderas, bEscudos, bAnimales, bBolaDragon, bHarryPotter, bJugadoresBetis;
	private AudioClip audioButton;
	
	public MenuController(MenuMemorion menuMemorion) {
		this.menuMemorion = menuMemorion;
		
		reproducirSonido("sounds/musicMenu.mp3");
		
		this.bBanderas = this.menuMemorion.getbBanderas();
		this.bBanderas.setOnAction(this);
		
		this.bEscudos = this.menuMemorion.getbEscudos();
		this.bEscudos.setOnAction(this);
		
		this.bAnimales = this.menuMemorion.getbAnimales();
		this.bAnimales.setOnAction(this);
		
		this.bBolaDragon = this.menuMemorion.getbBolaDragon();
		this.bBolaDragon.setOnAction(this);
		
		this.bHarryPotter = this.menuMemorion.getbHarryPotter();
		this.bHarryPotter.setOnAction(this);
		
		this.bJugadoresBetis = this.menuMemorion.getbJugadoresBetis();
		this.bJugadoresBetis.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		
		if ((Button)event.getSource() == this.bBanderas)
			changeView("img/banderas");
		else if ((Button)event.getSource() == this.bEscudos)
			changeView("img/escudos");
		else if ((Button)event.getSource() == this.bAnimales)
			changeView("img/animales");
		else if ((Button)event.getSource() == this.bBolaDragon)
			changeView("img/bolaDragon");
		else if ((Button)event.getSource() == this.bHarryPotter)
			changeView("img/HarryPotter");
		else if ((Button)event.getSource() == this.bJugadoresBetis)
			changeView("img/jugadoresBetis");
	}
	
	public void changeView(String carpeta) {
		Tablero tablero;
		try {
			if (this.audioButton.isPlaying())
				this.audioButton.stop();
			
			tablero = new Tablero(carpeta);
			TableroController tableroController = new TableroController(tablero);
			
			Scene scene = new Scene(tablero,1920,995);
			Stage stage = (Stage)this.menuMemorion.getScene().getWindow();
			stage.setScene(scene);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
 
	public void reproducirSonido(String nombreSonido) {
		this.audioButton = new AudioClip(Paths.get(nombreSonido).toUri().toString());
		audioButton.play(1);
	}
	
}
