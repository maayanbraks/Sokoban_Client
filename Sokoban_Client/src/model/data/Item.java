/**
* This class responsible to represent General Item - Actor
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.Serializable;

public abstract class  Item implements Serializable{
	private char ch;
	private Position2D pos;
	
	public Item(){
		this.pos=new Position2D();
		ch='*';
	}
	public Item(Item item)
	{
		this.pos=new Position2D(item.getPos());
		this.ch=item.getCh();
	}

	public Item(Position2D pos) {
		this.pos=new Position2D(pos);
	}
	
	public String getType(){
		return "Item";
	}
	
	public Position2D getPos() {
		return pos;
	}

	public void setPos(Position2D pos) {
		this.pos = new Position2D(pos);
	}
	
	public char getCh() {
		return this.ch;
	}
	
	protected void setCh(char ch) {
		this.ch = ch;
	}
}
