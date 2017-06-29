/**
* This class responsible to load TXT File
* @author Maayan & Eden
* @version 2D
*/
package model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import common.Level2D;



public class MyTextLevelLoader implements LevelLoader {

	public MyTextLevelLoader() {
	}

	public Level2D loadLevel(InputStream in) {
		String str=new String();
		int width =0;
		int height =0;
		char[][] map;

		String id="0";

		try{
			BufferedReader buffer=new BufferedReader(new InputStreamReader(in));

			height=stringToInt(buffer.readLine());
			width =stringToInt(buffer.readLine());

			map=new char[height][width];

			for(int i=0;i<height;i++){
				str=buffer.readLine();
				for(int j=0;j<width;j++){
					map[i][j]=str.charAt(j);
				}
			}

			id=buffer.readLine();
		}

		catch(IOException e)
		{
			map=new char[0][0];
			System.out.println("Somthing Wrong With the File reader");
		}

//INIT ARRAY LIST (MAYBE IN CHAR TO LEVEL)
		return charToLevel2D(map, width, height, id);
	}

	/**
	* This function get mat of chars and return mat of Items
	*/
	public Level2D charToLevel2D(char[][] charMap, int width, int height, String id){
		ItemCreator ic=new ItemCreator();
		Item[][] itemMap=new Item[height][width];
		Level2D newLevel=new Level2D(height, width, itemMap, id);

		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				itemMap[i][j]=ic.createItem(charMap[i][j]);
				itemMap[i][j].setPos(new Position2D(i,j));
				if(itemMap[i][j].getType().compareTo("TargetBox")==0 ||
						charMap[i][j]=='?' || charMap[i][j]=='$')//was target under the item
				{
					itemMap[i][j].setPos( new Position2D(i, j, true) );
					newLevel.addTargetBoxToArray(new TargetBox(new Position2D(i, j, true)));
				}
				ItemAdder ia=new ItemAdder(newLevel, itemMap[i][j]);
				newLevel= ia.addItem(itemMap[i][j].getCh());
			}
		}
		newLevel.setMap(itemMap, height, width);
		return newLevel;
	}

	//get the buffer string and return the int value (for size of the map)
		private int stringToInt(String str)	{
			int num=0;
			for(int i=0;i<str.length() && str.charAt(i)>='0' &&  str.charAt(i)<='9';i++)
				num= (str.charAt(i)-'0')+(num*10);

			return num;
		}
}