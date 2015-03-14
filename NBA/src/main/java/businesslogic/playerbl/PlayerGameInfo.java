/*
 * 以下信息指总数据
 */
package businesslogic.playerbl;

public class PlayerGameInfo {
	
	public PlayerGameInfo(String name, String team, double time, int inTime,
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
	double time; //在场时间(单位:秒)
	
	int inTime;//参赛场数
	int firstTime;//先发场数
    
    double hitShootNum; //投篮命中数
    double shootNum; //投篮出手数
	
	double threePointNum; //三分命中数
	double threeShootNum; //三分出手数
	
	double freeHitNum; //罚球命中数
	double freeNum; //罚球出手数
	
	double rebAttNum; //进攻篮板数
	double rebDefNum; //防守篮板数
	double rebTotalNum; //总篮板数
	
	double assistNum;//助攻数
	double stealNum;//抢断数
    double blockNum;//盖帽数
    double errorNum;//失误数
    double foulNum;//犯规数
    
    int score; //个人得分
    
    double shooting;//投篮命中率
    double threeRate;//三分命中率
    double freeRate;//罚球命中率
    
    double rate;//效率
    double GMSC;//GmSc效率
    double realHitRate;//真实命中率
    double throwRate;//投篮效率
    double rebRate;//篮板率
    double attRebRate;//进攻篮板率
    double defRebRate;//防守篮板率
    double assistRate;//助攻率
    double stealRate;//抢断率
    double blockRate;//盖帽率
    double errorRate;//失误率
    double usedRate;//使用率
}
