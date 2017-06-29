/**
* This class responsible to manage the GUI
* @author Maayan & Eden
*/

package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GUIController extends Observable implements View, Initializable {

	char[][] _map = null;
	int count;
	@FXML
	WarehouseDisplayer warehouseDisplayer;
	@FXML
	Text counter;
	@FXML
	Text timer;
	@FXML
	Text title;
	@FXML
	Button solveButton;
	@FXML
	Button hintButton;

	String levelId;
	StringProperty CounterTimer;
	Timer time;
	String musicFile = "./resources/media/trololo.mp3";
	private KeysDefinitions keysDefinitions;

	// music
	Media song = new Media(new File(musicFile).toURI().toString());
	MediaPlayer mp = new MediaPlayer(song);
	// music - END

	Stage _primaryStage;
	Stage _secondStage;// GameOver Screen
//	private GameOverController goc;// GameOver Screen Controller

	boolean isTimerOn;

	public void setWarehouse(char[][] map, String levelId) {
		this._map = map;
		this.levelId = levelId;
		warehouseDisplayer.setWarehouse(map);
		warehouseDisplayer.redraw();
	}

	public void startCounter() {
		time = new Timer();
		time.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				setTimerCounter(getTimerCounter() + 1);
			}
		}, 0, 1000);
	}

	public void setTimerCounter(int num) {
		this.count = num;
		if (num == 0)
			this.CounterTimer.set(String.valueOf(num));
		else
			this.CounterTimer.set("" + count);
	}

	public int getTimerCounter() {
		return count;
	}

	public void setCounter(int counter) {
		String str = String.valueOf(counter);
		this.counter.setText(str);
	}

	public void setTitle(String comment) {
		String str = String.valueOf(comment);
		this.title.setText(str);
	}

	public void setComment(String comment) {
		String str = String.valueOf(comment);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		isTimerOn = false;
		CounterTimer = new SimpleStringProperty();
		this.setTimerCounter(0);
		timer.textProperty().bind(CounterTimer);

		// music
		mp.setVolume(0.7);
		mp.play();
		// music -end

		try {
			this.keysDefinitions = new KeysDefinitions(new FileInputStream("resources/settings/DefaultKeys.xml"));

		} catch (FileNotFoundException e1) {
			setKeys();
		}

		warehouseDisplayer.setWarehouse(_map);
		warehouseDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> warehouseDisplayer.requestFocus());
		// set keys
		warehouseDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				move(event.getCode().toString().toLowerCase());
			}
		});
		
		//SET Buttons (hint & solve)
		solveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setChanged();
				notifyObservers("solve");
			}
		});
		hintButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setChanged();
				notifyObservers("hint");
			}
		});

	}

	// Keys settings functions
	public void setKeys() {
		try {
			this.keysDefinitions = new KeysDefinitions(new FileInputStream("resources/settings/Keys.xml"));
		} catch (IOException e) {

		}
	}

	@Override
	public void move(String str) {

		setComment(":)");
		if (_map != null) {
			String command = this.keysDefinitions.getCommandFromKey(str);
			if (command != null) {
				warehouseDisplayer.setActorFileName("./resources/images/" + command + ".png");
				setChanged();
				notifyObservers("move " + command);
			}
		}
	}

	@Override
	public void start() {
		warehouseDisplayer.printBackground();
	}

	public void load() {
		this.title.setText("SOKOBAN");
		if (_map != null) {

			time.cancel();
		}

		this.setTimerCounter(0);

		FileChooser fc = new FileChooser();
		fc.setTitle("Load Level");
		fc.setInitialDirectory(new File("./resources/levels"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("text(*.txt)", "*.txt"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML(*.xml)", "*.xml"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Object(*.obj)", "*.obj"));
		File chosen = fc.showOpenDialog(null);

		if (chosen != null) {
			String path = chosen.getName();

			setChanged();
			notifyObservers("load ./resources/levels/" + path);
			this.startCounter();
			isTimerOn = true;

		} else
			System.out.println("WHAT??");

	}

	public void save() {

		FileChooser fc = new FileChooser();
		fc.setTitle("Save Level");
		fc.setInitialDirectory(new File("./resources/levels"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("text(*.txt)", "*.txt"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML(*.xml)", "*.xml"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Object(*.obj)", "*.obj"));
		File chosen = fc.showSaveDialog(null);
		if (chosen != null) {
			String path = chosen.getName();
			setChanged();
			notifyObservers("save ./resources/levels/" + path);
		}
	}

	@Override
	public void exit() {
		setComment("Bye");
		setChanged();
		notifyObservers("exit");

	}

	public void closeStage() {
		this._primaryStage.close();
	}

	@Override
	public void setStage(Stage primaryStage) {
		this._primaryStage = primaryStage;
	}

	public void setSecondStage(Stage stage) {
		this._secondStage = stage;
	}

	public void stopTimer() {
		if (isTimerOn)
			time.cancel();
	}

	// GAME OVER CONTROL
/*
	public void setGameOverController(GameOverController g) {
		this.goc = g;
	}
*/
	public void finish() {
		stopTimer();
		setTitle("You Won!");
	/*	this.goc.initData(this.levelId, this.count, (Integer.parseInt(this.counter.getText())));
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				_secondStage.show();
			}
		});*/
	}

}
