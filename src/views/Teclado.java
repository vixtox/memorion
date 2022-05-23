package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Teclado extends GridPane {
	
	Button [] bArray;
	
	public Teclado() {
		this.bArray = new Button [27];
		this.bArray = getTecladoQwerty();
		
		for (int i = 0, f = 0, c = 0; i < this.bArray.length; i++) {
			this.add(this.bArray[i], c, f);
			
			c++;
				
			if (i == 9 || i == 19) {
				f++;
				c = 0;
			}
			
		}
	
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
	}
	
	public String [] distribucionQwerty() {
		String [] qwerty = {"Q","W","E","R","T","Y","U","I","O","P",// Primera fila
			"A","S","D","F","G","H","J","K","L","Ñ",				// Segunda fila
			"Z","X","C","V","B","N","M"};							// Tercera fila
		
		return qwerty;
	}
	
	public Button [] getTecladoQwerty() {
		Button tecla = null;
		for (int i = 0; i < 27; i++) {
			String letra = distribucionQwerty()[i];// Conseguir letra del botón 
			
			tecla = new Button(letra);
			tecla = getDesignBotton(tecla);// Conseguir diseño del botón
			this.bArray [i] = tecla;
		}
		
		return this.bArray;
		
	}
	
	public Button getDesignBotton(Button button) {
		button.setMinSize(100, 100);
		BorderStroke borderStroke = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null,new BorderWidths(2));
        Border border = new Border(borderStroke);
        button.setBorder(border);
        button.setFont(new Font("Arial",40));
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        hoverMouse(button,"YELLOW");
        
		return button;
	}
	
	public void hoverMouse(Button btn, String color) {
		final DropShadow shadowBotton = new DropShadow();
		shadowBotton.setColor(Color.valueOf(color));
		// Poner sombra cuado pase el cursor
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> btn.setEffect(shadowBotton));
		// Quitar sombra cuando se quite el cursor
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, e -> btn.setEffect(null));
	}
	
	public Button [] getTecladoAlfabetico() {
		Button tecla = null;
		for (int i = 0; i < 26; i++) {
			char asci = 97;
			asci = (char)(asci + i);
			String letra = String.valueOf(asci); 
			
			tecla = new Button(letra);
			tecla = getDesignBotton(tecla);
			this.bArray [i] = tecla;
		}
		tecla = new Button("ñ");
		tecla = getDesignBotton(tecla);
		this.bArray [26] = tecla;
		
		return this.bArray;
		
	}

	public Button[] getbArray() {
		return bArray;
	}
	
}