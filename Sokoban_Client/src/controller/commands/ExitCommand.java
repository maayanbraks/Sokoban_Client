/**
* This class responsible to run the 'exit' command
* @author Maayan & Eden
*/

package controller.commands;


import controller.Controller;
import javafx.application.Platform;
import model.Model;
import view.View;

public class ExitCommand extends GeneralCommand{

	View _view;
	Controller _controller;


	/**
	* C'TOR
	*/

	public ExitCommand(Model model,View view,Controller controller) {
		super(model);
		this._view=view;
		this._controller=controller;
	}

	public void execute() {

		_model.exit();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				_view.closeStage();

			}
		});

		_controller.stop();
	}
}