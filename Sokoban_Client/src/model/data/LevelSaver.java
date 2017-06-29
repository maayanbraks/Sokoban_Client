package model.data;

import java.io.IOException;
import java.io.OutputStream;

import common.Level2D;


public interface LevelSaver {
	public void SaveLevel(OutputStream out,Level2D lvl) throws IOException;

}
