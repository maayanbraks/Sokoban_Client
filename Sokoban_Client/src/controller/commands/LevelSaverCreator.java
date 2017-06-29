package controller.commands;

import model.data.LevelSaver;

public abstract class LevelSaverCreator {
	private String _saveComment;
	String _filePath;

	public LevelSaverCreator(String path) {
		_filePath=path;
		this._saveComment= "accept" ;//default comment (only if we create level loader its ok)
	}

	public abstract LevelSaver create();

	public void unknownPath(){
		setComment("I cant find this path....");
	}

	public void setComment(String comment) {
		_saveComment=comment;
	}

	public String getComment() {
		return _saveComment;
	}

	public String getPath() {
		return this._filePath;
	}
}

