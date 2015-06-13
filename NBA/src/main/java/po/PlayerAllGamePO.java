package po;

import java.util.ArrayList;
import java.util.HashSet;

public class PlayerAllGamePO{

	private static HashSet<String> eastTeams=null;
	
	private String playerName;
	private String teamName;
	private ArrayList<PlayerGamePO> gameDataList;
	private String area=null;
    
	
	static{
		eastTeams=new HashSet<String>();
		eastTeams.add("ATL");
		eastTeams.add("BOS");
		eastTeams.add("CHA");
		eastTeams.add("CHI");
		eastTeams.add("CLE");
		eastTeams.add("DET");
	    eastTeams.add("MIA");
		eastTeams.add("MIL");
		eastTeams.add("NYK");
		eastTeams.add("ORL");
		eastTeams.add("PHI");
		eastTeams.add("TOR");
		eastTeams.add("WAS");
		eastTeams.add("BKN");
		eastTeams.add("IND");
	}
	
	
	public PlayerAllGamePO(){
		gameDataList=new ArrayList<PlayerGamePO>();
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
		if(eastTeams.contains(teamName))
			this.area="East";
		else
			this.area="West";
	}

	public void setGameDataList(ArrayList<PlayerGamePO> gameDataList) {
		this.gameDataList = gameDataList;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public ArrayList<PlayerGamePO> getGameDataList() {
		return gameDataList;
	}

	public String getTeamName() {
		return teamName;
	}
	public void addMatch(PlayerGamePO po){
		if(po!=null)
		gameDataList.add(po);
		
		gameDataList.sort(null);
		
	}
	public String getArea() {
		return area;
	}
}
