package businesslogic.playerbl;

import test.data.PlayerNormalInfo;

public class PlayerNInfo {
	
	private String position;
	private String league;
	private int age;
	private PlayerNormalInfo pni;
	
	public PlayerNInfo(String position, String league, int age,
			PlayerNormalInfo pni) {
		this.position = position;
		this.league = league;
		this.age = age;
		this.pni = pni;
	}

	public String getPosition() {
		return position;
	}

	public String getLeague() {
		return league;
	}

	public int getAge() {
		return age;
	}

	public PlayerNormalInfo getPni() {
		return pni;
	}
}
