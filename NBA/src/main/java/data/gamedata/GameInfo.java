package data.gamedata;

import java.util.ArrayList;

import po.PlayerGamePO;
import po.TeamGamePO;

public class GameInfo {

	private TeamGamePO teamGame1=null;
	private TeamGamePO teamGame2=null;
	private ArrayList<PlayerGamePO> gameList=null;
	
	

	public GameInfo(){
		gameList=new ArrayList<PlayerGamePO>();
	}
	
	public TeamGamePO getTeamGame1() {
		return teamGame1;
	}

	public void setTeamGame1(TeamGamePO teamGame1) {
		this.teamGame1 = teamGame1;
	}

	public TeamGamePO getTeamGame2() {
		return teamGame2;
	}

	public void setTeamGame2(TeamGamePO teamGame2) {
		this.teamGame2 = teamGame2;
	}

	public ArrayList<PlayerGamePO> getGameList() {
		return gameList;
	}
	public void setGameList(ArrayList<PlayerGamePO> gameList) {
		this.gameList = gameList;
	}
	

	
	
	
}
