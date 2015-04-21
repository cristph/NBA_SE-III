package po;

import java.util.ArrayList;

public class TeamAllGamePO {

	String teamName;
	ArrayList<TeamGamePO> gameDataList;
	
	public TeamAllGamePO(){
		gameDataList=new ArrayList<TeamGamePO>();
		
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<TeamGamePO> getGameDataList() {
		return gameDataList;
	}
	public void setGameDataList(ArrayList<TeamGamePO> gameDataList) {
		this.gameDataList = gameDataList;
	}
	public void addGame(TeamGamePO po){
		if(po!=null)
		gameDataList.add(po);
		gameDataList.sort(null);
		
	}
}
