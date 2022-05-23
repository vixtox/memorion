package application;
	
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.Clasificacion;
import views.GuardarPuntuacion;
import views.MenuMemorion;
import views.Tablero;
import views.Teclado;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			MenuMemorion root = new MenuMemorion();
			MenuController menuController = new MenuController(root);
			
			Scene scene = new Scene(root,1920,995);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Memorion");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
