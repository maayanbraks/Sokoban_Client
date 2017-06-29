/**
* This class responsible to represent specific Item - Target Box
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public class TargetBox extends Item implements Serializable{
	
	/**
	* C"TOR
	*/
	public TargetBox( ) {
		super();
		setCh('o');
		Position2D newPos = new Position2D(this.getPos().getX(), this.getPos().getY(), true);
		this.setPos(newPos);
	}
	
	/**
	* C'TOR
	*/
	public TargetBox(Position2D pos) {
		super(pos);
		setCh('o');
		Position2D newPos = new Position2D(this.getPos().getX(), this.getPos().getY(), true);
		this.setPos(newPos);
	}
	
	/**
	* return the type
	*/
	public String getType(){
		return "TargetBox";
	}

}
