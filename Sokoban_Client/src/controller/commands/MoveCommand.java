/**
* This class responsible to run the 'move' command
* @author Maayan & Eden
* @version 2D
*/

package controller.commands;


import model.Model;

import model.data.Position2D;



public class MoveCommand extends GeneralCommand{
	String _direction;

/**
* C'TOR
*/
	public MoveCommand(String direction, Model model) {
		super(model);
		_direction=direction;
	}


	public void execute() {

		//init dest position
		Position2D dest=new Position2D(_model.getLevel().getActors().get(0).getPos());



		//Calculate the destination
		switch(this._direction){
		case "right":
			dest.setY(dest.getY()+1);
			break;
		case "left":
			dest.setY(dest.getY()-1);
			break;
		case "up":
			dest.setX(dest.getX()-1);
			break;
		case "down":
			dest.setX(dest.getX()+1);
			break;
		default:
			setComment("This direction is unknown!!!\n" + "Please try again:");
		}

		//END Calculate

		_model.move(dest);

	}
}
