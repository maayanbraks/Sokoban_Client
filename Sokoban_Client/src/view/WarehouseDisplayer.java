/**
* This class responsible on the level items presentation
* @author Maayan & Eden
*/
package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class WarehouseDisplayer extends Canvas{

	private char [][] warehouse;
	private StringProperty wallFileName;
	private StringProperty actorFileName;
	private StringProperty boxFileName;
	private StringProperty targetFileName;
	private StringProperty spaceFileName;
	private StringProperty backgroundFileName;

	private String levelId;



	public WarehouseDisplayer() {
		wallFileName=new SimpleStringProperty();
		actorFileName=new SimpleStringProperty();
		boxFileName=new SimpleStringProperty();
		targetFileName=new SimpleStringProperty();
		spaceFileName=new SimpleStringProperty();
		backgroundFileName=new SimpleStringProperty();


	}

	public void printBackground(){
		GraphicsContext gc=getGraphicsContext2D();
		Image background=null;

		try {
			background=new Image(new FileInputStream(backgroundFileName.get()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		gc.clearRect(0, 0, getWidth(), getHeight());

		if(background==null){
			gc.setFill(Color.GREEN);
			gc.fillRect(0, 0, getWidth(), getHeight());
		}
		else
			gc.drawImage(background,0, 0, getWidth(), getHeight());
	}

	public String getBackgroundFileName() {
		return backgroundFileName.get();
	}

	public void setBackgroundFileName(String backgroundFileName) {
		this.backgroundFileName.set(backgroundFileName);
	}

	public char[][] getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(char[][] warehouse) {
		this.warehouse = warehouse;
		redraw();
		}

	public String getWallFileName() {
		return wallFileName.get();
	}

	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}

	public String getActorFileName() {
		return actorFileName.get();
	}

	public void setActorFileName(String actorFileName) {
		this.actorFileName.set(actorFileName);
	}

	public String getBoxFileName() {
		return boxFileName.get();
	}

	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}

	public String getTargetFileName() {
		return targetFileName.get();
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName.set(targetFileName);
	}

	public String getSpaceFileName() {
		return spaceFileName.get();
	}

	public void setSpaceFileName(String spaceFileName) {
		this.spaceFileName.set(spaceFileName);
	}

	public void redraw(){
		if(warehouse!=null){
			double W=getWidth();
			double H=getHeight();
			double w=W/warehouse[0].length;
			double h=H/warehouse.length;

			GraphicsContext gc=getGraphicsContext2D();
			Image wall=null;
			Image actor=null;
			Image box=null;
			Image target=null;
			Image space=null;

			//get the files
			try {
				wall=new Image(new FileInputStream(wallFileName.get()));
				actor=new Image(new FileInputStream(actorFileName.get()));
				box=new Image(new FileInputStream(boxFileName.get()));
				target=new Image(new FileInputStream(targetFileName.get()));
				space=new Image(new FileInputStream(spaceFileName.get()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			gc.clearRect(0, 0, W, H);

			for (int i=0;i<warehouse.length;i++){
				for (int j=0;j<warehouse[i].length;j++){
					switch(warehouse[i][j]){
					//box
						case '@':
							if(box==null){
								gc.setFill(Color.GREEN);
								gc.fillRect(j*w, i*h, w, h);
							}
							else
								gc.drawImage(box,j*w, i*h, w, h);
						break;
					//wall
						case '#':
							if(wall==null){
								gc.setFill(Color.RED);
								gc.fillRect(j*w, i*h, w, h);
							}
							else
								gc.drawImage(wall,j*w, i*h, w, h);
						break;
					//actor
						case 'A':
							if(actor==null){
								gc.setFill(Color.ORANGE);
								gc.fillRect(j*w, i*h, w, h);
							}
							else
								gc.drawImage(actor,j*w, i*h, w, h);
						break;
				   //target box
						case 'o':
							if(target==null){
								gc.setFill(Color.BLUE);
								gc.fillRect(j*w, i*h, w, h);
							}
							else
								gc.drawImage(target,j*w, i*h, w, h);
						break;
				  //space
						case ' ':
							if(space==null){
								gc.setFill(Color.YELLOW);
								gc.fillRect(j*w, i*h, w, h);
							}
							else
								gc.drawImage(space,j*w, i*h, w, h);
						break;
				//DEFAULT
						default:
							gc.fillRect(j*w, i*h, w, h);
					}
				}
			}
		}
	}



}
