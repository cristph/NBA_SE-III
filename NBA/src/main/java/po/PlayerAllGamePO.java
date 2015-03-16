package po;

import java.util.ArrayList;

public class PlayerAllGamePO {

	private String playerName;
	private String teamName;
	private ArrayList<PlayerGamePO> gameDataList;
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	}
}
