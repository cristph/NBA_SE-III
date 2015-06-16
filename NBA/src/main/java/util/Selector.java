package util;

public class Selector {
	
	public Selector(String season, String kind) {
		this.season = season;
		this.kind = kind;
	}
	public Selector(){}
	
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
	public boolean equals(Selector st){
		boolean b1=st.getKind().equals(kind);
		boolean b2=st.getSeason().equals(season);
		return b1&&b2;
    }


	
}
