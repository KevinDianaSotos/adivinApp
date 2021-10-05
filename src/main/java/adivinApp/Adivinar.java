package adivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Adivinar extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	private Label solucionLabel;
	private Button comprobarButton;
	private TextField palabraText;
	private int random = (int) Math.floor(Math.random()*(100-1+1)+1);
	private int intentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		palabraText = new TextField();
		palabraText.setPrefColumnCount(5);
		palabraText.setPromptText("Introduce una sentencia");
		palabraText.setMaxWidth(150);

		solucionLabel = new Label();
		solucionLabel.setText("Introduce un número del 1 al 100");

		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(solucionLabel, palabraText, comprobarButton);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp Kevin Diana");
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {
		String palabra = palabraText.getText();
		int numero = 0;
		try {
			numero = Integer.parseInt(palabra);
		} catch (NumberFormatException nfe){
		}
		
	    Alert correcto = new Alert(AlertType.INFORMATION);
		Alert fallaste = new Alert(AlertType.WARNING); 
		Alert error = new Alert(AlertType.ERROR);
		
		if(numero==random) {
			
			 intentos++;
			 correcto.setTitle("AdivinApp");
			 correcto.setHeaderText("¡Has ganado!");
			 correcto.setContentText(String.format("Solo has necesitado %d intentos. \n\n Vuelve a intentarlo.", intentos));
			 correcto.showAndWait();
			
		}
		else if (numero <= 0 || numero > 100) {
			
			   error.setTitle("AdivinApp");
			   error.setHeaderText("Error");
			   error.setContentText("El número introducido no es válido.");
			   error.showAndWait();
			
		}
		else {
			
			 fallaste.setTitle("AdivinApp");
			 fallaste.setHeaderText("¡Has fallado!");
			 if(numero<random)
				 fallaste.setContentText(String.format("El número a adivinar es mayor que %d \n\n Vuelve a intentarlo. ", numero));
			 else {
				 fallaste.setContentText(String.format("El número a adivinar es menor que %d \n\n Vuelve a intentarlo. ", numero));

			 }
			 fallaste.showAndWait();
			 intentos++;
			
		}

	}

}
