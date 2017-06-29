//this is the Basic View of game
/**
* This class responsible to represent the position.
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public class Position2D implements Serializable {
	private int _x;// up-down
	private int _y;// right-left
	private boolean _wasTarget;// if the position is target box

	/**
	 * C'TOR
	 */
	public Position2D() {
		this._x = 0;
		this._y = 0;

		_wasTarget = false;
	}

	/**
	 * C'TOR
	 */
	public Position2D(int x, int y) {
		this._x = x;
		this._y = y;

		_wasTarget = false;
	}

	/**
	 * C'TOR
	 */
	public Position2D(int x, int y, boolean target) {
		this._x = x;
		this._y = y;
		this._wasTarget = target;
	}

	/**
	 * copy C'TOR
	 */
	public Position2D(Position2D newPos) {
		this._x = newPos._x;
		this._y = newPos._y;
		this._wasTarget = newPos._wasTarget;
	}

	/**
	 * Getters and Setters
	 */
	public boolean isWasTarget() {
		return _wasTarget;
	}

	public void setWasTarget(boolean wasTarget) {
		this._wasTarget = wasTarget;
	}

	public int getX() {
		return _x;
	}

	public void setX(int x) {
		this._x = x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int y) {
		this._y = y;
	}

	public Position2D up() {
		return new Position2D(_x - 1, _y);
	}

	public Position2D down() {
		return new Position2D(_x + 1, _y);
	}

	public Position2D left() {
		return new Position2D(_x, _y - 1);
	}

	public Position2D right() {
		return new Position2D(_x, _y + 1);
	}

	@Override
	public boolean equals(Object obj) {
		if ((this._x == ((Position2D) obj)._x) && (this._y == ((Position2D) obj)._y))
			return true;
		else
			return false;

	}

	@Override
	public int hashCode() {
		String code = "(" + Integer.toString(_x) + "," + Integer.toString(_y) + ")";
		return code.hashCode();
	}

	@Override
	public String toString() {
		String str = "(" + Integer.toString(_x) + "," + Integer.toString(_y) + ")";
		return str;
	}

}
