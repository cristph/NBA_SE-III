package data.playerdata;

import java.io.File;
import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerPO;
import dataservice.playerdataservice.PlayerDataService;


public class PlayerData implements PlayerDataService {
	
	

	public ArrayList<PlayerPO> getPlayerData() {
		// TODO Auto-generated method stub
		String path="/data/players/info";
		
		File rootFile=new File(path);
		File array[]=rootFile.listFiles();
		
		PlayerDataReadService prService=new PlayerDataReader();
		ArrayList<PlayerPO> list=new ArrayList<PlayerPO>();
		for(int i=0;i<array.length;i++)
		{
			if(array[i].isFile())
			{
				String playerPath=array[i].getPath();
				PlayerPO temp=prService.getPlayerPo(playerPath);
				list.add(temp);
			}
		}
		
		
		return list;
	}

	public ArrayList<PlayerAllGamePO> getPlayerGameData() {
		// TODO Auto-generated method stub
		return null;
	}


}
