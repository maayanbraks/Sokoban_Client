/**
* This class responsible to represent Items that can move (Actor/Box)
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

import common.Level2D;



public class Moveable extends Item implements Serializable{

	private boolean _wasTarget;

	/**
	* C'TOR
	*/
	public Moveable() {
		super();
		_wasTarget=false;
	}

	/**
	* C'TOR
	*/
	public Moveable(Position2D pos) {
		super (pos);

	}

	/**
	* Getters and Setters
	*/
	public boolean getWasTarget(){
		return this._wasTarget;
	}

	public void setWasTarget(boolean bool){
		this._wasTarget=bool;
	}

	/*
	protected boolean movable(Position2D dest,Level2D map) {
		if( (map.getItemInPlace(dest).getType().compareTo("Wall"))==0)
			return false;

		return true;
	}
	*/

	/**
	* functions that does the move physically
	*/
	public void move(Position2D old,Position2D dest,Level2D map) {
	//	if( movable(dest, map) ){
			map.setItemInPlace(this, dest);//Move the item
			this.setPos(dest);
			if(!old.isWasTarget()){
				Space spc=new Space(old);
				map.setItemInPlace( spc , old);
			}
			else{
				map.setItemInPlace( new TargetBox(old) , old);
			}
/*
			return true;
		}
		this.setPos(old);
		return false;
		*/
	}

}
