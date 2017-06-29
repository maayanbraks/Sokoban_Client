/**
* This class responsible to represent specific Item - Wall
* @author Maayan & Eden
* @version 2D
*/
package model.data;

import java.io.Serializable;

public class Wall extends Item  implements Serializable{
	
	/**
	* C'TOR
	*/
	public Wall() {
		super();
		setCh('#');
	}
	
	/**
	* C'TOR
	*/
	public Wall(Position2D pos) {
		super(pos);
		setCh('#');
	}
	
	/**
	* rturn the type
	*/
	public String getType(){
		return "Wall";
	}

}
