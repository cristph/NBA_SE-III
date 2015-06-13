package data.gamedata;

public class Selector {
	
	public Selector(String season, String kind) {
		this.season = season;
		this.kind = kind;
	}
	
	private String season;
	private String kind;
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	

	
}
