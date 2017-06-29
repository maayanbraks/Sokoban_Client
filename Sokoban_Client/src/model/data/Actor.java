/**
* This class responsible to represent specific Item - Actor
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public class Actor extends Moveable implements Serializable{
	
	/**
	* C'TOR
	*/
	public Actor() {
		super();
		this.setWasTarget(false);
		this.setCh('A');
	}
	
	/**
	* C'TOR
	*/
	public Actor(Position2D pos) {
		super(pos);
		this.setWasTarget(false);
		this.setCh('A');
	}
	
	/**
	* This function return type of the item
	*/
	public String getType(){
		return "Actor";
	}
}
