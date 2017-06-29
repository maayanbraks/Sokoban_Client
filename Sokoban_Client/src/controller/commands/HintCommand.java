package controller.commands;

import model.Model;

public class HintCommand extends GeneralCommand{
	
	public HintCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		if(_model.getLevel()!=null)
			this._model.hint();
		
	}
	
}
