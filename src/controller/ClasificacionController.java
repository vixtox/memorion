package controller;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.Clasificacion;
import views.MenuMemorion;

public class ClasificacionController implements EventHandler<ActionEvent>{
	
	private Clasificacion root;
	private Button bGoMenu;
	
	public ClasificacionController(Clasificacion root) {
		this.root = root;
		
		this.bGoMenu = this.root.getbGoMenu();
		this.bGoMenu.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {

		if ((Button)event.getSource() == this.bGoMenu) {
			
			try {
				changeView();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void changeView() throws FileNotFoundException {
		MenuMemorion root = new MenuMemorion();
		Scene scene = new Scene(root,1920,995);
		
		Stage stage = (Stage)this.root.getScene().getWindow();
		stage.setScene(scene);
		
		MenuController menuController = new MenuController(root);

		
	}

}
