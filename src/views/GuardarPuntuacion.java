package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class GuardarPuntuacion extends BorderPane{
	
	private Teclado teclado;
	private Label lIniciales;
	
	public GuardarPuntuacion() {
		this.teclado = new Teclado();
		
		Label lTitulo = new Label("Guardar puntuación");
		designLabel(lTitulo);
		
		this.lIniciales = new Label("");
		designLabel(lIniciales);
		
		
		this.setTop(lTitulo);
		this.setCenter(lIniciales);
		this.setBottom(teclado);
		
		this.setPadding(new Insets(100));
		this.setAlignment(lTitulo, Pos.CENTER);
		this.backgroundProperty().set(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}

	public void designLabel(Label label) {
		label.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		label.setTextFill(Color.WHITE);
		label.setFont(new Font("Times New Roman",90));
		label.setMinSize(750,120);
		label.setTextAlignment(TextAlignment.CENTER);
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public Label getlIniciales() {
		return lIniciales;
	}

	public void setlIniciales(Label lIniciales) {
		this.lIniciales = lIniciales;
	}

}
