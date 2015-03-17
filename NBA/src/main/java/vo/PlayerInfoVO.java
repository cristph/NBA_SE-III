package vo;

public class PlayerInfoVO {
	
	public PlayerInfoVO(String name, String team, double time, int inTime,
			int firstTime, double hitShootNum, double shootNum,
			double threePointNum, double threeShootNum, double freeHitNum,
			double freeNum, double rebAttNum, double rebDefNum,
			double rebTotalNum, double assistNum, double stealNum,
			double blockNum, double errorNum, double foulNum, double score,
			double shooting, double threeRate, double freeRate, double rate,
			double gMSC, double realHitRate, double throwRate, double rebRate,
			double attRebRate, double defRebRate, double assistRate,
			double stealRate, double blockRate, double errorRate,
			double usedRate,String order,int doub,double par) {
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
		this.shooting = shooting;
		this.threeRate = threeRate;
		this.freeRate = freeRate;
		this.rate = rate;
		GMSC = gMSC;
		this.realHitRate = realHitRate;
		this.throwRate = throwRate;
		this.rebRate = rebRate;
		this.attRebRate = attRebRate;
		this.defRebRate = defRebRate;
		this.assistRate = assistRate;
		this.stealRate = stealRate;
		this.blockRate = blockRate;
		this.errorRate = errorRate;
		this.usedRate = usedRate;
		this.order = order;
		
		this.doub=doub;
		this.par=par;
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
    
    double score; //个人得分
    
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
    String order;//需要选项
    
    int doub;//二双次数
    double par;//得分/篮板/助攻(加权比1:1:1)
    
	public String getName() {
		return name;
	}
	public String getTeam() {
		return team;
	}
	public double getTime() {
		return time;
	}
	public int getInTime() {
		return inTime;
	}
	public int getFirstTime() {
		return firstTime;
	}
	public double getHitShootNum() {
		return hitShootNum;
	}
	public double getShootNum() {
		return shootNum;
	}
	public double getThreePointNum() {
		return threePointNum;
	}
	public double getThreeShootNum() {
		return threeShootNum;
	}
	public double getFreeHitNum() {
		return freeHitNum;
	}
	public double getFreeNum() {
		return freeNum;
	}
	public double getRebAttNum() {
		return rebAttNum;
	}
	public double getRebDefNum() {
		return rebDefNum;
	}
	public double getRebTotalNum() {
		return rebTotalNum;
	}
	public double getAssistNum() {
		return assistNum;
	}
	public double getStealNum() {
		return stealNum;
	}
	public double getBlockNum() {
		return blockNum;
	}
	public double getErrorNum() {
		return errorNum;
	}
	public double getFoulNum() {
		return foulNum;
	}
	public double getScore() {
		return score;
	}
	public double getShooting() {
		return shooting;
	}
	public double getThreeRate() {
		return threeRate;
	}
	public double getFreeRate() {
		return freeRate;
	}
	public double getRate() {
		return rate;
	}
	public double getGMSC() {
		return GMSC;
	}
	public double getRealHitRate() {
		return realHitRate;
	}
	public double getThrowRate() {
		return throwRate;
	}
	public double getRebRate() {
		return rebRate;
	}
	public double getAttRebRate() {
		return attRebRate;
	}
	public double getDefRebRate() {
		return defRebRate;
	}
	public double getAssistRate() {
		return assistRate;
	}
	public double getStealRate() {
		return stealRate;
	}
	public double getBlockRate() {
		return blockRate;
	}
	public double getErrorRate() {
		return errorRate;
	}
	public double getUsedRate() {
		return usedRate;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String str){
		this.order=str;
	}
	public int getDoub() {
		return doub;
	}
	public double getPar() {
		return par;
	}
}
