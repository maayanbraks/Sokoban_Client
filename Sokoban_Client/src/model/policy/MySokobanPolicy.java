/**
* This class represent the game Policy
* @author Maayan & Eden
* @version 2D
*/

package model.policy;


import common.Level2D;
import model.data.Position2D;

public class MySokobanPolicy {
	Position2D _old;
	Level2D _lvl;

	/**
	 * C'TOR
	 */
	public MySokobanPolicy(Position2D old, Level2D lvl) {
		_old = old;
		_lvl = lvl;
	}

	/**
	 * This function check the rules of movement
	 */
	public boolean check(Position2D dest) {
		if (dest.getX() < 0 || dest.getY() < 0 || dest.getX() >= _lvl.getHeight() || dest.getY() >= _lvl.getWidth())
			return false;
		if (thereIsWall(dest))
			return false;

		return (pushBox(dest));
	}

	/**
	 * This functions check specific rules
	 */
	// return true if there is Wall
	private boolean thereIsWall(Position2D dest) {
		if ((_lvl.getItemInPlace(dest).getType().compareTo("Wall")) == 0)
			return true;
		return false;
	}

	// return true if the box can move
	private boolean pushBox(Position2D dest) {
		if ((_lvl.getItemInPlace(dest).getType().compareTo("Box")) == 0)
			return boxPushBox(newPos(dest), _lvl);

		return true;

	}

	// (dest is the updated destination)
	private boolean boxPushBox(Position2D dest, Level2D lvl) {
		if (((lvl.getItemInPlace(dest).getType().compareTo("Box")) == 0) || thereIsWall(dest))// if
																								// box
																								// after
																								// box
																								// OR
																								// wall
																								// after
																								// box
			return false;

		return true;
	}

	/**
	 * This function return the policy
	 */
	public String getPolicy() {
		return "1.You cant move through walls.\n" + "2.You cant push box into wall/box";
	}

	/**
	 * This function HELP us calculate new position.
	 */
	public Position2D newPos(Position2D dest) {
		// calculate the change on the Position from Move
		int xChange = dest.getX() - _old.getX();
		int yChange = dest.getY() - _old.getY();
		// calculate the new Position
		Position2D newPos = new Position2D((dest.getX() + xChange), (dest.getY() + yChange), (dest.isWasTarget()));
		return newPos;
	}

	/**
	 * This function check if the user finish the game.
	 */
	public boolean isFinished() {// this func checking if the game finished
		for (int i = 0; i < _lvl.getTargetBoxes().size(); i++) {
			if ((_lvl.getItemInPlace(_lvl.getTargetBoxes().get(i).getPos()).getType()) != "Box")
				return false;
		}
		return true;
	}
}
