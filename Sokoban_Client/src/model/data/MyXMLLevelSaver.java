/**
* This class responsible to save XML File
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;

import common.Level2D;



public class MyXMLLevelSaver implements LevelSaver {

	public void SaveLevel(OutputStream out, Level2D lvl) throws IOException {
		XMLEncoder xml=new XMLEncoder(out);
		xml.writeObject(lvl);
		XMLSaver(xml,lvl);
		xml.close();
	}

	public XMLEncoder XMLSaver(XMLEncoder xml, Level2D lvl) {
		for (int i=0;i<lvl.getHeight();i++)
			for(int j=0;j<lvl.getWidth();j++)
				xml.writeObject(lvl.getMap()[i][j]);
		return xml;
	}


}