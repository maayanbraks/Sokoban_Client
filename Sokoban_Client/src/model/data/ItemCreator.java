/**
* This class responsible to create Item (Actor/Box/Wall/Target Box/Space(floor)
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.util.HashMap;

public class ItemCreator {
	private HashMap<Character,Creator> _hm;
	
	/**
	* C'TOR
	*/
	public ItemCreator() {
		_hm=new HashMap<Character,Creator>();
		_hm.put('A',new ActorCreator());
		_hm.put('@',new BoxCreator());
		_hm.put('#',new WallCreator());
		_hm.put('o',new TargetBoxCreator());
		_hm.put(' ',new SpaceCreator());
		
		_hm.put('?',new BoxOnTargetCreator());
		_hm.put('$',new ActorOnTargetCreator());
	}
	
	/**
	* This function call the specific Item creator
	*/
	public Item createItem(Character ch)
	{
		Creator creator=_hm.get(ch);
		if (creator==null){
			return null;

		}
		return creator.create();
	}
	
	
	//Private Classes Creators
	private class ActorCreator implements Creator
	{
		public Item create() {
			return new Actor();
		}
	}
	
	private class BoxCreator implements Creator
	{
		public Item create() {
			return new Box();
		}
	}
	
	private class WallCreator implements Creator
	{
		public Item create() {
			return new Wall();
		}
	}
	
	private class TargetBoxCreator implements Creator
	{
		public Item create() {
			return new TargetBox();
		}
	}
	
	private class SpaceCreator implements Creator
	{
		public Item create() {
			return new Space();
		}
	}
	
	private class BoxOnTargetCreator implements Creator
	{
		public Item create() {
			return new Box();
		}
	}
	
	private class ActorOnTargetCreator implements Creator
	{
		public Item create() {
			return new Actor();
		}
	}
}
