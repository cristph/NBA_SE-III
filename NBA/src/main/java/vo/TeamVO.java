package vo;

import java.awt.Image;

public class TeamVO {
	String teamName; //球队全名
    String shortName; //缩写
	
	String location; //所在地
	String compArea; //赛区
	String zone; //分区
	String home; //主场
	String birthday; //建立时间
	
	
	Image teamPic; //球队标志
	
	int gamenum;//比赛场数
	
	//赛季总数据
	int allpoint;//总得分
	
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
    
    double shootrate;//投篮命中率
    double threepointrate;//三分命中率
    double freehitrate;//罚球命中率
    double winrate;//胜率
    double attackround;//进攻回合
    double attackrate;//进攻效率
    double defendrate;//防守效率
    double rebattrate;//进攻篮板效率
    double rebdefrate;//防守篮板效率
    double stealrate;//抢断效率
    double assistrate;//助攻率
	//赛季总数据
    
    
    //赛季平均数据
    int allpointave;//平均得分
    
  	int hitShootNumave; //投篮命中数
  	int shootNumave; //投篮出手数
  	
  	int threePointNumave; //三分命中数
  	int threeShootNumave; //三分出手数
  	
  	int freeHitNumave; //罚球命中数
  	int freeNumave; //罚球出手数
  	
  	int rebAttNumave; //进攻篮板数
  	int rebDefNumave; //防守篮板数
  	int rebTotalNumave; //总篮板数
  	
  	int assistNumave;//助攻数
  	int stealNumave;//抢断数
    int blockNumave;//盖帽数
    int errorNumave;//失误数
    int foulNumave;//犯规数
  	
    double shootrateave;//投篮命中率
    double threepointrateave;//三分命中率
    double freehitrateave;//罚球命中率
    double winrateave;//胜率
    double attackroundave;//进攻回合
    double attackrateave;//进攻效率
    double defendrateave;//防守效率
    double rebattrateave;//进攻篮板效率
    double rebdefrateave;//防守篮板效率
    double stealrateave;//抢断效率
    double assistrateave;//助攻率
  	//赛季平均数据
    
    
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
	public int getGamenum() {
		return gamenum;
	}
	public void setGamenum(int gamenum) {
		this.gamenum = gamenum;
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
	public double getShootrate() {
		return shootrate;
	}
	public void setShootrate(double shootrate) {
		this.shootrate = shootrate;
	}
	public double getThreepointrate() {
		return threepointrate;
	}
	public void setThreepointrate(double threepointrate) {
		this.threepointrate = threepointrate;
	}
	public double getFreehitrate() {
		return freehitrate;
	}
	public void setFreehitrate(double freehitrate) {
		this.freehitrate = freehitrate;
	}
	public double getWinrate() {
		return winrate;
	}
	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}
	public double getAttackround() {
		return attackround;
	}
	public void setAttackround(double attackround) {
		this.attackround = attackround;
	}
	public double getAttackrate() {
		return attackrate;
	}
	public void setAttackrate(double attackrate) {
		this.attackrate = attackrate;
	}
	public double getDefendrate() {
		return defendrate;
	}
	public void setDefendrate(double defendrate) {
		this.defendrate = defendrate;
	}
	
	public double getStealrate() {
		return stealrate;
	}
	public void setStealrate(double stealrate) {
		this.stealrate = stealrate;
	}
	public double getAssistrate() {
		return assistrate;
	}
	public void setAssistrate(double assistrate) {
		this.assistrate = assistrate;
	}
	public int getHitShootNumave() {
		return hitShootNumave;
	}
	public void setHitShootNumave(int hitShootNumave) {
		this.hitShootNumave = hitShootNumave;
	}
	public int getShootNumave() {
		return shootNumave;
	}
	public void setShootNumave(int shootNumave) {
		this.shootNumave = shootNumave;
	}
	public int getThreePointNumave() {
		return threePointNumave;
	}
	public void setThreePointNumave(int threePointNumave) {
		this.threePointNumave = threePointNumave;
	}
	public int getThreeShootNumave() {
		return threeShootNumave;
	}
	public void setThreeShootNumave(int threeShootNumave) {
		this.threeShootNumave = threeShootNumave;
	}
	public int getFreeHitNumave() {
		return freeHitNumave;
	}
	public void setFreeHitNumave(int freeHitNumave) {
		this.freeHitNumave = freeHitNumave;
	}
	public int getFreeNumave() {
		return freeNumave;
	}
	public void setFreeNumave(int freeNumave) {
		this.freeNumave = freeNumave;
	}
	public int getRebAttNumave() {
		return rebAttNumave;
	}
	public void setRebAttNumave(int rebAttNumave) {
		this.rebAttNumave = rebAttNumave;
	}
	public int getRebDefNumave() {
		return rebDefNumave;
	}
	public void setRebDefNumave(int rebDefNumave) {
		this.rebDefNumave = rebDefNumave;
	}
	public int getRebTotalNumave() {
		return rebTotalNumave;
	}
	public void setRebTotalNumave(int rebTotalNumave) {
		this.rebTotalNumave = rebTotalNumave;
	}
	public int getAssistNumave() {
		return assistNumave;
	}
	public void setAssistNumave(int assistNumave) {
		this.assistNumave = assistNumave;
	}
	public int getStealNumave() {
		return stealNumave;
	}
	public void setStealNumave(int stealNumave) {
		this.stealNumave = stealNumave;
	}
	public int getBlockNumave() {
		return blockNumave;
	}
	public void setBlockNumave(int blockNumave) {
		this.blockNumave = blockNumave;
	}
	public int getErrorNumave() {
		return errorNumave;
	}
	public void setErrorNumave(int errorNumave) {
		this.errorNumave = errorNumave;
	}
	public int getFoulNumave() {
		return foulNumave;
	}
	public void setFoulNumave(int foulNumave) {
		this.foulNumave = foulNumave;
	}
	public double getShootrateave() {
		return shootrateave;
	}
	public void setShootrateave(double shootrateave) {
		this.shootrateave = shootrateave;
	}
	public double getThreepointrateave() {
		return threepointrateave;
	}
	public void setThreepointrateave(double threepointrateave) {
		this.threepointrateave = threepointrateave;
	}
	public double getFreehitrateave() {
		return freehitrateave;
	}
	public void setFreehitrateave(double freehitrateave) {
		this.freehitrateave = freehitrateave;
	}
	public double getWinrateave() {
		return winrateave;
	}
	public void setWinrateave(double winrateave) {
		this.winrateave = winrateave;
	}
	public double getAttackroundave() {
		return attackroundave;
	}
	public void setAttackroundave(double attackroundave) {
		this.attackroundave = attackroundave;
	}
	public double getAttackrateave() {
		return attackrateave;
	}
	public void setAttackrateave(double attackrateave) {
		this.attackrateave = attackrateave;
	}
	public double getDefendrateave() {
		return defendrateave;
	}
	public void setDefendrateave(double defendrateave) {
		this.defendrateave = defendrateave;
	}
	
	public double getStealrateave() {
		return stealrateave;
	}
	public void setStealrateave(double stealrateave) {
		this.stealrateave = stealrateave;
	}
	public double getAssistrateave() {
		return assistrateave;
	}
	public void setAssistrateave(double assistrateave) {
		this.assistrateave = assistrateave;
	}
	public int getAllpoint() {
		return allpoint;
	}
	public void setAllpoint(int allpoint) {
		this.allpoint = allpoint;
	}
	public double getRebattrate() {
		return rebattrate;
	}
	public void setRebattrate(double rebattrate) {
		this.rebattrate = rebattrate;
	}
	public double getRebdefrate() {
		return rebdefrate;
	}
	public void setRebdefrate(double rebdefrate) {
		this.rebdefrate = rebdefrate;
	}
	public int getAllpointave() {
		return allpointave;
	}
	public void setAllpointave(int allpointave) {
		this.allpointave = allpointave;
	}
	public double getRebattrateave() {
		return rebattrateave;
	}
	public void setRebattrateave(double rebattrateave) {
		this.rebattrateave = rebattrateave;
	}
	public double getRebdefrateave() {
		return rebdefrateave;
	}
	public void setRebdefrateave(double rebdefrateave) {
		this.rebdefrateave = rebdefrateave;
	}
	

}
