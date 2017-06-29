/**
* This class add item to the level
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.util.HashMap;

import common.Level2D;



public class ItemAdder {
	private HashMap<Character,Adder> _hm;
	private Level2D _lvl;
	private Item _itm;

	public ItemAdder(Level2D lvl, Item itm){
		this._lvl=lvl;
		this._itm=itm;

		_hm=new HashMap<Character,Adder>();
		_hm.put('A',new ActorAdder());
		_hm.put('@',new BoxAdder());
		_hm.put('#',new WallAdder());
		_hm.put('o',new TargetBoxAdder());
		_hm.put(' ',new SpaceAdder());
	}

	public Level2D addItem(Character ch)
	{
		Adder adder=_hm.get(ch);
		if (adder==null){
			return null;

		}
		return adder.add();
	}



//Private Classes Creators
		private class ActorAdder implements Adder
		{
			public Level2D add() {
				_lvl.addActorToArray(_itm);
				return _lvl;
			}
		}

		private class BoxAdder implements Adder
		{
			public Level2D add() {
				_lvl.addBoxToArray(_itm);
				return _lvl;
			}
		}

		private class WallAdder implements Adder
		{
			public Level2D add() {
				_lvl.addWallToArray(_itm);
				return _lvl;
			}
		}

		private class TargetBoxAdder implements Adder
		{
			public Level2D add() {
				_lvl.addTargetBoxToArray(_itm);
				return _lvl;
			}
		}

		private class SpaceAdder implements Adder
		{
			public Level2D add() {
				_lvl.addSpaceToArray((Space)_itm);
				return _lvl;
			}
		}
}


