/*
 * version 0.1 2015-3-11
 */
package po;

public class TeamGamePO  extends GamePO implements Comparable<TeamGamePO>{
	
	String teamName;//球队名称
	String[] partScore;//长度为4的数组用于记录每一节的比分情况
	int allPlayerTime; //球队所有队员上场时间（单位：秒）
	
	public int compareTo(TeamGamePO po) {
		// TODO Auto-generated method stub
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

    public String getTeamName() {
		return teamName;
	}

    public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

    public String[] getPartScore() {
		return partScore;
	}

    public void setPartScore(String[] partScore) {
		this.partScore = partScore;
	}

    public int getAllPlayerTime() {
		return allPlayerTime;
	}

    public void setAllPlayerTime(int allPlayerTime) {
		this.allPlayerTime = allPlayerTime;
	}
	
    public String toString(){
    	return matchDate+";"+matchPair+";"+matchResult+";";
    }
}
