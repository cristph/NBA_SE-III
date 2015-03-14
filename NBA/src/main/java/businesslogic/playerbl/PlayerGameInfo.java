/*
 * 以下信息指总数据
 */
package businesslogic.playerbl;

public class PlayerGameInfo {
	
	public PlayerGameInfo(String name, String team, String time, int inTime,
			int firstTime, int hitShootNum, int shootNum, int threePointNum,
			int threeShootNum, int freeHitNum, int freeNum, int rebAttNum,
			int rebDefNum, int rebTotalNum, int assistNum, int stealNum,
			int blockNum, int errorNum, int foulNum, int score) {
		
		this.name = name;
		this.team = team;
		this.time = time;
		this.inTime = inTime;
		this.firstTime = firstTime;
		this.hitShootNum = hitShootNum;
		this.shootNum = shootNum;
		this.threePointNum = threePointNum;
		this.threeShootNum = threeShootNum;
		this.freeHitNum = freeHitNum;
		this.freeNum = freeNum;
		this.rebAttNum = rebAttNum;
		this.rebDefNum = rebDefNum;
		this.rebTotalNum = rebTotalNum;
		this.assistNum = assistNum;
		this.stealNum = stealNum;
		this.blockNum = blockNum;
		this.errorNum = errorNum;
		this.foulNum = foulNum;
		this.score = score;
	}

	String name;//名字
	String team;//所属球队
	String time; //在场时间(分钟:秒)
	
	int inTime;//参赛场数
    int firstTime;//先发场数
    
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
}
