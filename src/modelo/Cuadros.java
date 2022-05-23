package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cuadros {

	ArrayList<ImageView> cuadros;
	FileInputStream inputStream;
	Image image;
	ImageView cuadro;

	public Cuadros(String carpeta) throws FileNotFoundException {
		File folder = new File(carpeta);
		folderImages(folder,carpeta);		 
	}

	public void folderImages(File folder,String carpeta) throws FileNotFoundException {//Añadir fotos de la carpeta al ArrayList
		if (folder.isDirectory()) {
			String lista[] = folder.list();
			this.cuadros = new ArrayList<ImageView>();

			for (int i = 0; i < lista.length; i++) {
				this.inputStream = new FileInputStream(carpeta + "/" + lista[i]);
				this.image = new Image(inputStream);
				
				this.cuadro = new ImageView(image);
				this.cuadro.setId(lista[i]);
				
				this.cuadros.add(cuadro);
			}
		}
	}
	
	public ArrayList<ImageView> getCuadros() {
		return cuadros;
	}
	
}
