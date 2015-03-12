/*
 * version 0.1 2015-3-11
 */
package po;

public class PlayerGamePO {
	
	String name;
	String teamName;
	
		
	String position;
	String time; //在场时间(分钟:秒)
	
	int firstTime;//先发次数
	int gameTime;//参赛场数
	
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
