/**
* This class responsible to represent specific Item - Box
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public class Box extends Moveable implements Serializable{
	
	/**
	* C'TOR
	*/
	public Box() {
		super();
		this.setWasTarget(false);
		this.setCh('@');
	}
	
	/**
	* C'TOR
	*/
	public Box(Position2D pos) {
		super(pos);
		this.setWasTarget(false);
		this.setCh('@');
	}
	
	/**
	* This function return type of the item
	*/
	public String getType(){
		return "Box";
	}

}
