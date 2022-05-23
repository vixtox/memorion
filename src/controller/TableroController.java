package controller;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.Memorion;
import views.GuardarPuntuacion;
import views.Tablero;

public class TableroController implements EventHandler<ActionEvent>{

	private Tablero tablero;
	private Button [] arrayButton;
	private ImageView [] arrayImageView;
	private int countJugada;
	private Button [] visibilidadBotones;
	private ImageView [] visibilidadImageView;
	private Memorion memorion;
	private String [] id;
	private int intentos;
	
	public TableroController(Tablero tablero){
		this.tablero = tablero;
	
		this.arrayButton = this.tablero.getArrayButton();
		this.arrayImageView = this.tablero.getArrayFichas();
		
		this.countJugada = 0;
		this.intentos = 0;
		this.visibilidadBotones = new Button[2];
		this.visibilidadImageView = new ImageView[2];
		this.id = new String [2];
		this.memorion = new Memorion();

		for (int i = 0; i < this.arrayButton.length; i++) {
			this.arrayButton[i].setOnAction(this);
			
		}
	}

	@Override
	public void handle(ActionEvent event) {
		
		for (int i = 0; i < this.arrayButton.length; i++) {
			
			if ((Button) event.getSource() == this.arrayButton[i] && this.countJugada < 2) {
				this.countJugada++;
				this.arrayButton[i].setVisible(false);
				this.arrayImageView[i].setVisible(true);

				if (this.countJugada == 1) {
					id[0] = this.arrayImageView[i].getId();
					visibilidadBotones[0] = this.arrayButton[i];
					visibilidadImageView[0] = this.arrayImageView[i];
				}

				if (this.countJugada == 2) {
					this.intentos++;
					id[1] = this.arrayImageView[i].getId();
					visibilidadBotones[1] = this.arrayButton[i];
					visibilidadImageView[1] = this.arrayImageView[i];
					
					if (memorion.checkMove(id[0], id[1])) { // Acierto
						reproducirSonido("sounds/acierto.mp3");
						this.countJugada = 0;

						if (memorion.endGame())
							try {
								victory();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}	

					} else { // Error
						reproducirSonido("sounds/error.mp3");
						delay(2000, () ->{
							visibilidadImageView[0].setVisible(false);
							visibilidadImageView[1].setVisible(false);
							visibilidadBotones[0].setVisible(true);
							visibilidadBotones[1].setVisible(true);
							this.countJugada = 0;
						});
						
					}

				} // Fin if, segunda ficha levantada
				
			} // Fin acción botón
			
		} // Fin for
		
	}

	public void changeView() throws FileNotFoundException {
		GuardarPuntuacion root = new GuardarPuntuacion();
		GuardarPuntuacionController guardarPuntuacionController = new GuardarPuntuacionController(root,this.intentos);
		
		Scene scene = new Scene(root,1920,995);
		Stage stage = (Stage)this.tablero.getScene().getWindow();
		stage.setScene(scene);
	}
	
	public static void delay(long millis, Runnable continuation) {
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(event -> continuation.run());
		new Thread(sleeper).start();
	}
	
	public void reproducirSonido(String nombreSonido) {
		AudioClip audioButton = new AudioClip(Paths.get(nombreSonido).toUri().toString());
		audioButton.play(1);
	}
	
	public void victory() throws FileNotFoundException {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Victory: " + this.intentos + " intentos");
		alert.showAndWait();
		changeView();
	}
	
}
