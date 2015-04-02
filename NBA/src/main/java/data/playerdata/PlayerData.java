package data.playerdata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import po.PlayerAllGamePO;
import po.PlayerPO;
import dataservice.playerdataservice.PlayerDataService;


public class PlayerData implements PlayerDataService {
	
	

	public ArrayList<PlayerPO> getPlayerData() {
		// TODO Auto-generated method stub
		String path="data/players/info";
		
		File rootFile=new File(path);
		File array[]=rootFile.listFiles();
		
		PlayerDataReadService prService=new PlayerDataReader();
		ArrayList<PlayerPO> list=new ArrayList<PlayerPO>();
		for(int i=0;i<array.length;i++)
		{
			if(array[i].isFile())
			{
				String playerName=array[i].getName();
				PlayerPO temp=prService.getPlayerPo(playerName);
				list.add(temp);
			}
		}
		
		
		return list;
	}

	public ArrayList<PlayerAllGamePO> getPlayerGameData() {
		PlayerGameDataReadService pgds=new PlayerGameDataReader();
		HashMap<String,PlayerAllGamePO> result=pgds.getPlayerGamePo();
		java.util.Iterator<String> it=result.keySet().iterator();
		ArrayList<PlayerAllGamePO> list=new ArrayList<PlayerAllGamePO>();
		while(it.hasNext()){
			String key=it.next();
			PlayerAllGamePO po=result.get(key);
			list.add(po);
			
		}
		
		 
		return list ;
	}


}
