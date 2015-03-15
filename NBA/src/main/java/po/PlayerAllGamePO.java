package po;

import java.util.ArrayList;

public class PlayerAllGamePO {

	String playerName;
	String teamName;
	ArrayList<PlayerGamePO> gameDataList;
	
	public String getPlayerName() {
		return playerName;
	}
	
	public ArrayList<PlayerGamePO> getGameDataList() {
		return gameDataList;
	}

	public String getTeamName() {
		return teamName;
	}
}
