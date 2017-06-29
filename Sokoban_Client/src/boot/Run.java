package boot;

import java.util.List;

import controller.SokobanController;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MyModel;
import view.GUIController;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Run extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			System.out.println("sokoban CLIENT - enjoy");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));

			BorderPane root = (BorderPane) loader.load();

			GUIController view = loader.getController();
			MyModel model = new MyModel();
			SokobanController controller = new SokobanController(model, view);

			model.addObserver(controller);
			view.addObserver(controller);

			List<String> args = getParameters().getRaw();

			String arg = "";
			String str = "";

			if (args.size() == 2) {
				arg = args.get(0);
				str = args.get(1);
			}

			int port = 0;
			for (int i = 0; i < str.length(); i++) {
				port = (port * 10) + (str.charAt(i) - '0');
			}

			if (arg.compareTo("-server") == 0) {
				System.out.println("SERVER");
			} else {
				Scene scene = new Scene(root, 700, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);

				view.start();
				primaryStage.show();
				view.setStage(primaryStage);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
