package model;

import common.Level2D;
import controller.commands.LevelLoaderCreator;
import controller.commands.LevelSaverCreator;
import model.data.Position2D;
import model.policy.MySokobanPolicy;

public interface Model {

	public Level2D getLevel();
	public void move(Position2D dest);
	public void setLevel(Level2D lvl);
	public void save(LevelSaverCreator ls);
	public MySokobanPolicy getPolicy();
	public void exit();
	public void load(LevelLoaderCreator lc);
	public void solve();
	public void hint();



}
