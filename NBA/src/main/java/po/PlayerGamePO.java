/*
 * version 1.1 2015-3-15
 */
package po;

public class PlayerGamePO {
	
	String position;//位置
	String team;//所代表的球队
	int time; //在场时间(秒)
	int matchDate;//比赛日期  1999-01-01
	String matchPair;//比赛双方
	String matchResult;//比赛结果
	
    boolean isFirst;//是否先发	
    
    int hitShootNum; //投篮命中数
	int shootNum; //投篮出手数
	
	int threePointNum; //三分命中数
	int threeShootNum; //三分出手数
	
	int freeHitNum; //罚球命中数
	int freeNum; //罚球出手数
	
	int rebAttNum; //进攻篮板数
	int rebDefNum; //防守篮板数
	int rebTotalNum; //总篮板数
	
	int assistNum;//助攻数
	int stealNum;//抢断数
    int blockNum;//盖帽数
    int errorNum;//失误数
    int foulNum;//犯规数
    
    int score; //个人得分
    int twoNum; //球员自己两分球出手数（不是球队）
    
    public String getPosition() {
		return position;
	}

	public int getTime() {
		return time;
	}

	public int getMatchDate() {
		return matchDate;
	}

	public String getMatchPair() {
		return matchPair;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public int getHitShootNum() {
		return hitShootNum;
	}

	public int getShootNum() {
		return shootNum;
	}

	public int getThreePointNum() {
		return threePointNum;
	}

	public int getThreeShootNum() {
		return threeShootNum;
	}

	public int getFreeHitNum() {
		return freeHitNum;
	}

	public int getFreeNum() {
		return freeNum;
	}

	public int getRebAttNum() {
		return rebAttNum;
	}

	public int getRebDefNum() {
		return rebDefNum;
	}

	public int getRebTotalNum() {
		return rebTotalNum;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public int getStealNum() {
		return stealNum;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public int getErrorNum() {
		return errorNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public int getScore() {
		return score;
	}

    public int getTwoNum() {
		return twoNum;
	}

}
