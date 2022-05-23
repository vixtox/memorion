package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.DbMemorion;
import modelo.Score;
import views.Clasificacion;
import views.GuardarPuntuacion;
import views.MenuMemorion;
import views.Teclado;

public class GuardarPuntuacionController implements EventHandler<ActionEvent>{
	
	private GuardarPuntuacion guardarPuntuacion;
	private Teclado teclado;
	private int intentos;
	private Button [] bArray;
	private Button bTecla;
	private char letter;
	private int countLetras;
	private Label lIniciales;
	private String nombre;
	
	public GuardarPuntuacionController(GuardarPuntuacion guardarPuntuacion, int intentos) {
		this.guardarPuntuacion = guardarPuntuacion;
		this.intentos = intentos;
		
		this.teclado = this.guardarPuntuacion.getTeclado();
		
		this.bArray = teclado.getbArray();

		this.lIniciales = this.guardarPuntuacion.getlIniciales();
		this.countLetras = 0;
		
		this.nombre = "";
		
		for (int i = 0; i < this.bArray.length; i++) {
			this.bTecla = this.bArray[i];
			this.bTecla.setOnAction(this);
			
			MenuMemorion menuMemorion;
			
			try {
				menuMemorion = new MenuMemorion();
				menuMemorion.hoverMouse(bTecla, "YELLOW");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void handle(ActionEvent event) {
		
		for (int i = 0; i < this.bArray.length; i++) {
			this.bTecla = this.bArray[i];
			
			if ((Button) event.getSource() == this.bTecla) {
				this.letter = this.bTecla.getText().toUpperCase().charAt(0); // Conseguir letra
				
				nombre += this.letter;
				this.lIniciales.setText(nombre);
				this.countLetras++;
				
				delay(1000, () ->{
					if (this.countLetras == 3) {
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = new Date();
						String fecha = dateFormat.format(date);
						
						Score score = new Score(0,nombre,intentos,fecha);
						DbMemorion m;
						try {	
							m = new DbMemorion();
							m.addScore(score);

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					
							try {
								changeView();
								
							} catch (FileNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						
					}
				});
				
			}
		}
		
		
	}
	
	public void changeView() throws SQLException, FileNotFoundException {	
		Clasificacion root = new Clasificacion();
		ClasificacionController clasificacionController = new ClasificacionController(root);
		Scene scene = new Scene(root,1920,995);
		
		Stage stage = (Stage)this.guardarPuntuacion.getScene().getWindow();
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

}
