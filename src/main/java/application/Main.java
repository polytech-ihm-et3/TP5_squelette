package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// On prépare le fichier FXML
			FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
			// On charge le fichier FXML, il appellera la méthode *initialize()* de la vue
			Parent root = loader.load();
			// On crée la scène
			Scene scene = new Scene(root);
			// On définit cette scène comme étant la scène de notre première fenêtre
			primaryStage.setScene(scene);
			// On rend cette fenêtre visible
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}