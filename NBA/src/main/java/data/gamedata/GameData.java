package data.gamedata;
import java.util.ArrayList;
import java.util.HashMap;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;


public class GameData implements GameDataService{

	private GameSqlServer gSql=null;
	
    public GameData()
    {
		gSql=new GameSqlServer();
	}
	
	public ArrayList<PlayerAllGamePO> getPlayerGameData(Selector st)
	{
		String kind=st.getKind();
		String season=st.getSeason();
		
		HashMap<String,PlayerAllGamePO> pMap=gSql.getPlayerGameData(season, kind);
		java.util.Iterator<String> it=pMap.keySet().iterator();
		
		
	    ArrayList<PlayerAllGamePO> list=new ArrayList<PlayerAllGamePO>();
        while(it.hasNext())
        {
			PlayerAllGamePO temp=pMap.get(it.next());
		    list.add(temp);
	    }
		return list;
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st) {
		String kind=st.getKind();
		String season=st.getSeason();
		
		HashMap<String,TeamAllGamePO> tMap=gSql.getTeamGameData(season, kind);
		java.util.Iterator<String> it=tMap.keySet().iterator();
		
		
	    ArrayList<TeamAllGamePO> list=new ArrayList<TeamAllGamePO>();
        while(it.hasNext())
        {
        	TeamAllGamePO temp=tMap.get(it.next());
		    list.add(temp);
	    }
		return list;
	}

    public ArrayList<PlayerGamePO> get_Latest_PlayerGameData(){
		return gSql.getLatestPlayer();
	}
    
    

}
