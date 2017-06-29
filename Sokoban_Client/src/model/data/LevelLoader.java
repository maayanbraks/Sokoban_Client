/**
 * Answers (page 2):
* 1.We have class for represent the level (Level2D) and these classes that load it
* 2.Because now we can just create Level3D class, for example, that inherit from
* 	Level2D, but the loader is the same class
* 3.The user does'nt know who is the class that run it
* 4.
*/

package model.data;

import java.io.InputStream;

import common.Level2D;



public interface LevelLoader {
	Level2D loadLevel(InputStream in) ;
}
