/**
* This class responsible to represent specific Item - Space (empty floor)
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public class Space extends Item implements Serializable{
	
	/**
	* C'TOR
	*/
	public Space() {
		super();
		this.setCh(' ');
	}
	
	/**
	* C'TOR
	*/
	public Space(Position2D pos) {
		super(pos);
		this.setCh(' ');
	}
	
	/**
	* Getters and Setters
	*/
	public String getType(){
		return "Space";
	}
}
