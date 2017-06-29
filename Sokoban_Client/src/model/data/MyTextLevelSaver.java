/**
* This class responsible to save TXT File
* @author Maayan & Eden
* @version 2D
*/

package model.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import common.Level2D;



public class MyTextLevelSaver implements LevelSaver{

	public void SaveLevel(OutputStream out, Level2D lvl) throws IOException {

		BufferedWriter buffer=new BufferedWriter(new OutputStreamWriter(out));
		//lvl.WriteIntoBuffer(buffer);
		WriteIntoBuffer(buffer,lvl);
		buffer.close();
	}

	public void WriteIntoBuffer(BufferedWriter buffer, Level2D lvl) throws IOException {
		buffer.write(""+lvl.getHeight());
		buffer.newLine();
		buffer.write(""+lvl.getWidth());
		Item itm;
		for (int i=0;i<lvl.getHeight();i++) {
			buffer.newLine();
			for (int j=0;j<lvl.getWidth();j++) {
				itm=lvl.getItemInPlace(new Position2D(i, j));

				if((itm.getPos().isWasTarget()) &&((itm.getType().compareTo("Actor")==0)))
						buffer.write('$');
				else if((itm.getPos().isWasTarget()) && ((itm.getType().compareTo("Box")==0)))
						buffer.write('?');
				else
					buffer.write(lvl.getMap()[i][j].getCh());
			}
		}
		buffer.newLine();
		buffer.write(""+lvl.getId());
	}
}
