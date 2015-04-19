package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerGamePO;

public class PlayerInfo {
	
	private String name; 
	private String position; //位置
	private int age;
	private String teamName;
	private ArrayList<PlayerGamePO> gameDataList;

	public PlayerInfo(String name, String position, int age,
			String teamName, ArrayList<PlayerGamePO> gameDataList) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.teamName = teamName;
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

	public ArrayList<PlayerGamePO> getGameDataList() {
		return gameDataList;
	}
}
