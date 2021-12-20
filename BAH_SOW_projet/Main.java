import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/*
 * Classe principale
 * Lance l'application dans une fenêtre mainStage
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) {
		// On lance un nouveau contrôleur
		new Controller(mainStage);
	}

}
