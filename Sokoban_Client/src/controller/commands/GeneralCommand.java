/**
* This class is "parent class" of all the command classses
* @author Maayan & Eden
* @version 2D
*/

package controller.commands;

import common.Level2D;
import model.Model;


public abstract class GeneralCommand implements Command{
	Model _model;
	String _comment;

	/**
	* C'TOR
	*/
	public GeneralCommand(Model model) {
		this._model=model;
		this._comment=new String("command accepted");
	}

	/**
	* This function return the level
	*/
	public Level2D get_lvl() {
		return _model.getLevel() ;
	}

	/**
	* This function does nothing. It here only for the Command Implementation
	*/
	public abstract void execute();


	public void setComment(String comment) {
		_comment=comment;
	}
	public String getComment() {
		return _comment;
	}
}
