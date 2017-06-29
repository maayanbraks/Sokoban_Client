/**
* This class responsible to run the 'load' command
* @author Maayan & Eden
* @version 2D
*/

package controller.commands;

import java.util.HashMap;

import model.Model;
import model.data.LevelLoader;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;
import view.View;

public class LoadCommand extends GeneralCommand {
	private String _path;
	private String _typeFile;
	private HashMap<String, LevelLoaderCreator> _hm = new HashMap<String, LevelLoaderCreator>();

	/**
	 * C'TOR
	 */
	public LoadCommand(String path, Model model) {
		super(model);
		this._path = path;

		this._typeFile = getTypeOfFile(path);// help func
		// Make HashMap
		_hm.put("txt", new TextLevelLoaderCreator());
		_hm.put("xml", new XmlLevelLoaderCreator());
		_hm.put("obj", new ObjectLevelLoaderCreator());
	}

	public void execute() {
		LevelLoaderCreator lc = _hm.get(_typeFile);
		if (lc == null)
			setComment("type file?!?!?!!?");
		else {
			_model.load(lc);
			this.setComment(lc.getComment());
		}
	}

	/**
	 * This function HELP us to get the type of the file from path
	 */
	private String getTypeOfFile(String pathtoFile) {
		String typefile = pathtoFile.substring(pathtoFile.length() - 3);
		return typefile;
	}

	/**
	 * Classes for our design
	 *
	 * @author Maayan & Eden
	 * @version 2D
	 */
	// TEXT FILE
	private class TextLevelLoaderCreator extends LevelLoaderCreator {

		public TextLevelLoaderCreator() {
			super(_path);

		}

		@Override
		public LevelLoader create() {

			return new MyTextLevelLoader();
		}
	}

	// Object File
	private class ObjectLevelLoaderCreator extends LevelLoaderCreator {

		public ObjectLevelLoaderCreator() {
			super(_path);
		}

		public LevelLoader create() {
			return new MyObjectLevelLoader();
		}
	}

	// XML File
	private class XmlLevelLoaderCreator extends LevelLoaderCreator {
		public XmlLevelLoaderCreator() {
			super(_path);
		}

		public LevelLoader create() {
			return new MyXMLLevelLoader();
		}
	}

}
