package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import modelo.Cuadros;

public class Tablero extends GridPane implements Cloneable{
	
	Button [] arrayButton;
	ImageView [] arrayFichas;
	
	public Tablero(String carpeta) throws FileNotFoundException {
		Cuadros c = new Cuadros(carpeta);
		ArrayList<ImageView> cuadros = c.getCuadros();
		ArrayList<ImageView> lista = clonarObjeto(carpeta);
		
		for (int i = 0; i < lista.size(); i++)
			cuadros.add(lista.get(i));
		
		Collections.shuffle(cuadros);
		posicionElementos(cuadros);
		this.setHgap(20);
		this.setVgap(20);
		this.setPadding(new Insets(20));
		this.setStyle("-fx-background-color: GREY;");
	}

	public void posicionElementos(ArrayList<ImageView> cuadros) {
		int f = 0; // Columnas
		int c = 0; // Filas
		this.arrayButton = new Button[cuadros.size()];
		this.arrayFichas = new ImageView[cuadros.size()];
		
		for (int i = 0; i < cuadros.size(); i++, c++) {	
			Button button = new Button("MEMORION");
			button.setMinSize(450, 175);
			
			cuadros.get(i).setFitWidth(450);
			cuadros.get(i).setFitHeight(175);
			cuadros.get(i).setVisible(false);
			
			this.arrayButton[i] = button;
			this.arrayFichas[i] = cuadros.get(i);
			
			this.add(cuadros.get(i), c, f);
			this.add(button, c, f);
			
			if (c == 3) {// 4 nodos por fila
				c = -1;
				f++;
			}			
		}
		
	}	
	
	public ArrayList<ImageView> clonarObjeto(String carpeta) throws FileNotFoundException{
		Cuadros c = new Cuadros(carpeta);
		Cuadros copia = c;
		ArrayList<ImageView> lista = copia.getCuadros();
		
		return lista;
	}

	public Button[] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(Button[] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public ImageView[] getArrayFichas() {
		return arrayFichas;
	}

	public void setArrayFichas(ImageView[] arrayFichas) {
		this.arrayFichas = arrayFichas;
	}

}
