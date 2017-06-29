/**
* This class responsible to load XML File
* @author Maayan & Eden
* @version 2D
*/
package model.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

import common.Level2D;



public class MyXMLLevelLoader implements LevelLoader {

	public Level2D loadLevel(InputStream in) {
		Level2D lvl;
		XMLDecoder XD=new XMLDecoder(new BufferedInputStream(in));
		lvl=(Level2D) XD.readObject();
		lvl.XMLReading(XD);
		XD.close();
		return lvl;
	}

}