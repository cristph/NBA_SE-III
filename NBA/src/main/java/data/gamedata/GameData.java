package data.gamedata;
import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import util.PlayerChoosor;
import util.Selector;


public class GameData implements GameDataService{

	private GameSqlServer gSql=null;
	
    public GameData()
    {
		gSql=new GameSqlServer();
	}
	
	public ArrayList<PlayerAllGamePO> getPlayerGameData(Selector st)
	{
		ArrayList<PlayerAllGamePO> list=gSql.getPlayerGameData(st);
	    return list;
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st) 
	{
		ArrayList<TeamAllGamePO> list=gSql.getTeamGameData(st);
		return list;
     }

    public ArrayList<PlayerGamePO> get_Latest_PlayerGameData(){
		return gSql.getLatestPlayer();
	}

	@Override
	public ArrayList<PlayerGamePO> getPlayerGameData_BySeason(PlayerChoosor pcs) {
		// TODO Auto-generated method stub
		return gSql.getPlayerGameData_BySeason(pcs);
	}
    
}
