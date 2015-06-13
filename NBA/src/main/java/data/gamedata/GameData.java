package data.gamedata;
import java.util.ArrayList;
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
		
		ArrayList<PlayerAllGamePO> list=gSql.getPlayerGameData(season, kind);
	
		return list;
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st) 
	{
		String kind=st.getKind();
		String season=st.getSeason();
		
		ArrayList<TeamAllGamePO> list=gSql.getTeamGameData(season, kind);
		
		return list;
     }

    public ArrayList<PlayerGamePO> get_Latest_PlayerGameData(){
		return gSql.getLatestPlayer();
	}
    
    

}
