package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerGamePO;

public class PlayerInfo {
	
	private String name; 
	private String position; //位置
	private int age;
	private String teamName;
	private String league;
	private ArrayList<PlayerGamePO> gameDataList;

	public PlayerInfo(String name, String position, int age, String teamName,
			String league, ArrayList<PlayerGamePO> gameDataList) {
		super();
		this.name = name;
		this.position = position;
		this.age = age;
		this.teamName = teamName;
		this.league = league;
		this.gameDataList = gameDataList;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getAge() {
		return age;
	}

	public String getTeamName() {
		return teamName;
	}
	
	public String getLeague() {
		return league;
	}

	public ArrayList<PlayerGamePO> getGameDataList() {
		return gameDataList;
	}
}
