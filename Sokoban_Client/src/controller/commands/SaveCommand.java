/**
* This class responsible to run the 'save' command
* @author Maayan & Eden
* @version 2D
*/
package controller.commands;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import common.Level2D;
import model.Model;
import model.data.LevelSaver;
import model.data.MyObjectLevelSaver;
import model.data.MyTextLevelLoader;
import model.data.MyTextLevelSaver;
import model.data.MyXMLLevelSaver;

public class SaveCommand extends GeneralCommand{
		String _path;
		String _typeFile;
		HashMap<String,LevelSaverCreator> _hm=new HashMap<String,LevelSaverCreator>();


		public SaveCommand(String path, Model model) {//start on ConcreteCommandCreator
			super(model);
			this._path=path;
			this._typeFile=getTypeofFile(path);
			_hm.put("txt",new TextLevelSaver());
			_hm.put("xml",new XMLLevelSaver());
			_hm.put("obj",new ObjectLevelSaver());


		}

		//HELP FUNCTION - START: get the type of the file from path
		private String getTypeofFile(String pathtoFile){
				String typefile=pathtoFile.substring(pathtoFile.length()-3);
					return typefile;
			}
		//HELP FUNCTION - END


		public void execute() {
			LevelSaverCreator ls=_hm.get(_typeFile);
			if(ls==null)
				setComment("type file?!?!?!!?");
			else{
				_model.save(ls);
				this.setComment(ls.getComment());
			}

		}

		//TEXT FILE
		private class TextLevelSaver extends LevelSaverCreator{

			public TextLevelSaver() {
				super(_path);
			}

			public LevelSaver create() {
				return new MyTextLevelSaver();

			}
		}

//OBJECT
		private	class ObjectLevelSaver extends LevelSaverCreator{
			public ObjectLevelSaver() {
				super(_path);
			}
			public LevelSaver create(){
				return new MyObjectLevelSaver();
			}
		}

		//XML File
		private	class XMLLevelSaver extends LevelSaverCreator{

			public XMLLevelSaver() {
				super(_path);
			}
			public LevelSaver create() {
				return new MyXMLLevelSaver();
			}
		}
}




