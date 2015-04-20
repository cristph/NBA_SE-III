package data.gamedata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;

public class GameData implements GameDataService {

	
	private static HashMap<String,TeamAllGamePO> teamMap=null;
	private static HashMap<String,PlayerAllGamePO> playerMap=null;
	private static File matchFold=null;

	
	static{
		teamMap=new HashMap<String,TeamAllGamePO>();
		playerMap=new HashMap<String,PlayerAllGamePO>();
		matchFold=new File("data/matches");
		initGameData();
	}
	
	private static void initGameData(){
		GameDataReadService gdrs=new GameDataReader();
		
		File[] array=matchFold.listFiles();
		for(int i=0;i<array.length;i++)
		{
			System.out.println("第"+i+"个文件");
			GameInfo gif=gdrs.readMatchFile(array[i]);
			TeamGamePO po1=gif.getTeamGame1();
			addTeamGamePO(po1);
			TeamGamePO po2=gif.getTeamGame2();
			addTeamGamePO(po2);
			
			ArrayList<PlayerGamePO> list=gif.getGameList(); 
			for(int j=0;j<list.size();j++)
			{
				addPlayerGamePO(list.get(j));
			}
			
		}
	}
	private static void addTeamGamePO(TeamGamePO po){
		boolean b=teamMap.containsKey(po.getTeamName());
		if(b)
		{
			teamMap.get(po.getTeamName()).addGame(po);
	    }
		else
		{
			String teamName=po.getTeamName();
			TeamAllGamePO allPo=new TeamAllGamePO();
			allPo.setTeamName(teamName);
			allPo.addGame(po);
			teamMap.put(teamName, allPo);
		}
	}
	
	private static void addPlayerGamePO(PlayerGamePO po){
		boolean b=playerMap.containsKey(po.getPlayerName());
		if(b)
		{
			playerMap.get(po.getPlayerName()).addMatch(po);
		}
		else
		{
			String playerName=po.getPlayerName();
			PlayerAllGamePO allPo=new PlayerAllGamePO();
			allPo.setPlayerName(playerName);
			allPo.setTeamName(po.getTeam());
			allPo.addMatch(po);
			playerMap.put(playerName, allPo);
		}
	}
	
	public ArrayList<PlayerAllGamePO> getPlayerGameData() {
		// TODO Auto-generated method stub
        java.util.Iterator<String> it=playerMap.keySet().iterator();
		
		ArrayList<PlayerAllGamePO> list=new ArrayList<PlayerAllGamePO>();
		while(it.hasNext()){
			PlayerAllGamePO temp=playerMap.get(it.next());
			list.add(temp);
		}
		
		return list;
   }

	public ArrayList<TeamAllGamePO> getTeamGameData() {
		// TODO Auto-generated method stub
        java.util.Iterator<String> it=teamMap.keySet().iterator();
		
		ArrayList<TeamAllGamePO> list=new ArrayList<TeamAllGamePO>();
		while(it.hasNext()){
			TeamAllGamePO temp=teamMap.get(it.next());
			list.add(temp);
		}
		
		return list;
	
	}

	public ArrayList<PlayerGamePO> get_Latest_PlayerGameData() {
		// TODO Auto-generated method stub
		return null;
	}

}
