package data.playerdata;

import java.io.File;
import java.util.ArrayList;

import po.PlayerPO;

public class Shiyan {

	public static void main(String[] args) {
		String path="data/players/info";
		
		File rootFile=new File(path);
		File array[]=rootFile.listFiles();
		
		
		for(int i=0;i<array.length;i++)
		{
			if(array[i].isFile())
			{
				String playerName=array[i].getName();
			    System.out.println(playerName);
			}
		}
		
		
		
	}

}
