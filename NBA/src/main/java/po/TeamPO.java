/*
 * version 0.1 2015-3-11
 */
package po;

import java.awt.Image;


public class TeamPO {
	
	String teamName; //球队全名
    String shortName; //缩写
	
	String location; //所在地
	String compArea; //赛区
	String zone; //分区
	String home; //主场
	String birthday; //建立时间
	
	
	Image teamPic; //球队标志
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompArea() {
		return compArea;
	}
	public void setCompArea(String compArea) {
		this.compArea = compArea;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Image getTeamPic() {
		return teamPic;
	}
	public void setTeamPic(Image teamPic) {
		this.teamPic = teamPic;
	}
	
}
