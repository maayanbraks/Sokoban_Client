/**
* This is the game controller
* @author Maayan & Eden
*/

package controller;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import controller.commands.CommandCreator;
import controller.commands.DisplayCommand;
import controller.commands.ExitCommand;
import controller.commands.FinishCommand;
import controller.commands.GeneralCommand;
import controller.commands.HintCommand;
import controller.commands.LoadCommand;
import controller.commands.MoveCommand;
import controller.commands.SaveCommand;
import controller.commands.SolveCommand;
import model.Model;
import model.MyModel;
import view.View;

public class SokobanController implements Observer {

	private HashMap<String, CommandCreator> _hm;
	private String _command;
	private String _info;

	Model _model;
	View _view;
	Controller _controller;

	private String _comment;

	/**
	 * C'TOR
	 */
	public SokobanController(Model model, View view) {
		this._model = model;
		this._view = view;
		this._controller = new Controller();
		this._controller.start();

		this._comment = "";

		initCommands();

	}

	protected void initCommands() {
		_hm = new HashMap<String, CommandCreator>();
		_hm.put("load", new LoadCommandCreator());
		_hm.put("display", new DisplayCommandCreator());
		_hm.put("move", new MoveCommandCreator());
		_hm.put("save", new SaveCommandCreator());
		_hm.put("finish", new FinishCommandCreator());
		_hm.put("exit", new ExitCommandCreator());
		_hm.put("solve", new SolveCommandCreator());
		_hm.put("hint", new HintCommandCreator());
	}

	/**
	 * Separate the string to command and info about the command. Create the
	 * command
	 *
	 * @param str
	 *            The command string (from Cli)
	 * @throws InterruptedException
	 */
	public void createCommandGeneral(String str) throws InterruptedException {
		String[] parts = str.split(" ");
		this._command = parts[0];
		if (parts.length > 1)
			this._info = parts[1];
		CommandCreator cc = _hm.get(this._command);

		if (cc == null) {
			this.setComment("Unknown command!!!!!");
		} else {

			GeneralCommand gc = cc.createCommand();
			_controller.insertCommand(gc);

			Thread.sleep(50);// waiting for comment update

			this.setComment(gc.getComment());
		}
	}

	public void update(Observable o, Object arg) {

		String str = "";
		str = (String) arg;
		try {
			this.createCommandGeneral(str);
		} catch (InterruptedException e) {
		}
	}

	public void setComment(String comment) throws InterruptedException {
		this._comment = comment;
		// _server.setMsgToClient(comment);
	}

	public String getComment() {
		return this._comment;
	}

	// Private Classes Creators
	private class LoadCommandCreator implements CommandCreator {

		public GeneralCommand createCommand() {
			return new LoadCommand(_info, _model);
		}
	}

	private class DisplayCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new DisplayCommand(_view, _model);
		}
	}

	private class MoveCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new MoveCommand(_info, _model);
		}
	}

	private class SaveCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new SaveCommand(_info, _model);
		}
	}

	private class ExitCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new ExitCommand(_model, _view, _controller);
		}
	}

	private class FinishCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new FinishCommand(_view, _model);
		}
	}
	
	private class SolveCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new SolveCommand(_model);
		}
	}
	
	private class HintCommandCreator implements CommandCreator {
		public GeneralCommand createCommand() {
			return new HintCommand(_model);
		}
	}

}
