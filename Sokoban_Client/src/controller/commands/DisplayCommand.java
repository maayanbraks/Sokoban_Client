/**
* This class responsible to run the 'display' command
* @author Maayan & Eden
*/

package controller.commands;


import model.Model;
import view.View;


public class DisplayCommand extends GeneralCommand{
	View _view;

	public DisplayCommand(View view, Model model) {
		super(model);
		this._view=view;
	}

	public void execute(){
		char[][] map=_model.getLevel().toChar();
		_view.setCounter(_model.getLevel().getCounter());
		_view.setWarehouse(map,_model.getLevel().getId());

	}
}
