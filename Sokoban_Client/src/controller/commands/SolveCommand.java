package controller.commands;

import model.Model;

public class SolveCommand extends GeneralCommand{

	public SolveCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		if(_model.getLevel()!=null)
			this._model.solve();	
	}
	
}
