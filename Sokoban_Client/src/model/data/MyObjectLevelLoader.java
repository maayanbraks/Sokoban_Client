/**
* This class responsible to load Object File
* @author Maayan & Eden
* @version 2D
*/
package model.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import common.Level2D;



public class MyObjectLevelLoader implements LevelLoader {
	public Level2D loadLevel(InputStream in) {
		Level2D newLevel=new Level2D();
		try {
		ObjectInputStream ois=new ObjectInputStream(in);
		newLevel=(Level2D)ois.readObject();
		ois.close();

	}
	catch (IOException e) {
	e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return newLevel;
		}
		return newLevel;
	}
}