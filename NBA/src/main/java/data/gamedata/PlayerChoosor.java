package data.gamedata;

public class PlayerChoosor {

	private String season;
	private String playerName;
	
	public PlayerChoosor(String sea,String playerName){
		this.season=sea;
		this.playerName=playerName;
	}
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
