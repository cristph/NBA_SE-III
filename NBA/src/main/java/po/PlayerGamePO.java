/*
 * version 1.1 2015-3-15
 */
package po;

import util.TeamInfo;

public class PlayerGamePO extends GamePO implements Comparable<PlayerGamePO>{
	
	String playerName;//球员姓名
	String position;//位置
	String team;//所代表的球队
	int time; //在场时间(秒)
	boolean isFirst;//是否先发
	
	int score; //个人得分
	int twoNum; //球员自己两分球出手数（不是球队）
    
	TeamInfo tif=null;//对手信息
	
	public String getPlayerName() {
		return playerName;
	}

    public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

    public String getPosition() {
		return position;
	}

    public void setPosition(String position) {
		this.position = position;
	}

    public String getTeam() {
		return team;
	}

    public void setTeam(String team) {
		this.team = team;
	}

    public int getTime() {
		return time;
	}

    public void setTime(int time) {
		this.time = time;
	}

    public boolean isFirst() {
		return isFirst;
	}

    public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

    public int getScore() {
		return score;
	}

    public void setScore(int score) {
		this.score = score;
	}

	public int getTwoNum() {
		return twoNum;
	}

    public void setTwoNum(int twoNum) {
		this.twoNum = twoNum;
	}

    public TeamInfo getTif() {
		return tif;
	}

    public void setTif(TeamInfo tif) {
		this.tif = tif;
	}

    public int compareTo(PlayerGamePO po){
		String s1[]=this.matchDate.split("-");
		String s2[]=po.getMatchDate().split("-");
		
		int date1=Integer.parseInt(s1[0]+s1[1]+s1[2]);
		int date2=Integer.parseInt(s2[0]+s2[1]+s2[2]);
		
		if(date1>date2)
			return -1;
		else if(date1<date2)
			return 1;
		return 0;
	}
    
    public String toString(){
    	return playerName+";"+position+";"+team+";"+score+";"+matchDate;
    }

}
