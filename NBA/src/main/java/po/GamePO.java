package po;

public abstract class  GamePO {
	
	String matchDate;//比赛日期
	String matchPair;//比赛双方
	String matchResult;//比赛结果 例如：100:99（本队在前）

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
    
    boolean isDirty=false;//是否为脏数据
    
	public boolean isDirty() {
		return isDirty;
	}
	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public String getMatchPair() {
		return matchPair;
	}
	public void setMatchPair(String matchPair) {
		this.matchPair = matchPair;
	}
	public String getMatchResult() {
		return matchResult;
	}
	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
	public int getHitShootNum() {
		return hitShootNum;
	}
	public void setHitShootNum(int hitShootNum) {
		this.hitShootNum = hitShootNum;
	}
	public int getShootNum() {
		return shootNum;
	}
	public void setShootNum(int shootNum) {
		this.shootNum = shootNum;
	}
	public int getThreePointNum() {
		return threePointNum;
	}
	public void setThreePointNum(int threePointNum) {
		this.threePointNum = threePointNum;
	}
	public int getThreeShootNum() {
		return threeShootNum;
	}
	public void setThreeShootNum(int threeShootNum) {
		this.threeShootNum = threeShootNum;
	}
	public int getFreeHitNum() {
		return freeHitNum;
	}
	public void setFreeHitNum(int freeHitNum) {
		this.freeHitNum = freeHitNum;
	}
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
	public int getRebAttNum() {
		return rebAttNum;
	}
	public void setRebAttNum(int rebAttNum) {
		this.rebAttNum = rebAttNum;
	}
	public int getRebDefNum() {
		return rebDefNum;
	}
	public void setRebDefNum(int rebDefNum) {
		this.rebDefNum = rebDefNum;
	}
	public int getRebTotalNum() {
		return rebTotalNum;
	}
	public void setRebTotalNum(int rebTotalNum) {
		this.rebTotalNum = rebTotalNum;
	}
	public int getAssistNum() {
		return assistNum;
	}
	public void setAssistNum(int assistNum) {
		this.assistNum = assistNum;
	}
	public int getStealNum() {
		return stealNum;
	}
	public void setStealNum(int stealNum) {
		this.stealNum = stealNum;
	}
	public int getBlockNum() {
		return blockNum;
	}
	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}
	public int getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	public int getFoulNum() {
		return foulNum;
	}
	public void setFoulNum(int foulNum) {
		this.foulNum = foulNum;
	}
}