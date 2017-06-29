/**
* This class responsible to save Object File
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import common.Level2D;



public class MyObjectLevelSaver implements LevelSaver {
	public void SaveLevel(OutputStream out, Level2D lvl) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(lvl);
	}
}