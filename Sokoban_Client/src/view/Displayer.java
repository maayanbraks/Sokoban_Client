/**
* This class responsible to print the level
* @author Maayan & Eden
* @version 2D
*/

package view;

import common.Level2D;
import model.data.Position2D;

public class Displayer {
	/**
	* Print to the screen
	*/
	public void print(Level2D _lvl) {
		for (int i=0;i<_lvl.getHeight();i++){
			System.out.println();
			for (int j=0;j<_lvl.getWidth();j++){
				System.out.print(_lvl.getItemInPlace(new Position2D(i,j)).getCh());
			}
		}
	System.out.println();
	}
}
