/**
* This class responsible on the finsh command
* @author Maayan & Eden
*/

package controller.commands;


import model.Model;
import view.View;

public class FinishCommand extends GeneralCommand {

	View _view;

	/**
	 * C'TOR
	 */
	public FinishCommand(View view, Model model) {
		super(model);
		this._view = view;
	}

	public void execute() {
		setComment("You Won!");

		_view.finish();
	}
}