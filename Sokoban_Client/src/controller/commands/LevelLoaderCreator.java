package controller.commands;

import model.data.LevelLoader;


public abstract class LevelLoaderCreator {

	private String _loadComment;
	String _filePath;

	public LevelLoaderCreator(String path) {
		_filePath=path;
		this._loadComment= "accept" ;//default comment (only if we create level loader its ok)

	}

	public abstract LevelLoader create();

	public void unknownPath(){
		setComment("I cant find this file....");

	}


	public void setComment(String comment) {
		_loadComment=comment;
	}

	public String getComment() {
		return _loadComment;
	}

	public String getPath() {
		return this._filePath;
	}

}
