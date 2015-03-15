package vo;

import java.awt.Image;

public class TeamVO {
	String teamName; //鐞冮槦鍏ㄥ悕
    String shortName; //缂╁啓
	
	String location; //鎵�鍦ㄥ湴
	String compArea; //璧涘尯
	String zone; //鍒嗗尯
	String home; //涓诲満
	String birthday; //寤虹珛鏃堕棿
	
	
	Image teamPic; //鐞冮槦鏍囧織
	
	int gamenum;//姣旇禌鍦烘暟
	
	//璧涘鎬绘暟
	int hitShootNum; //鎶曠鍛戒腑鏁�
	int shootNum; //鎶曠鍑烘墜鏁�
	
	int threePointNum; //涓夊垎鍛戒腑鏁�
	int threeShootNum; //涓夊垎鍑烘墜鏁�
	
	int freeHitNum; //缃氱悆鍛戒腑鏁�
	int freeNum; //缃氱悆鍑烘墜鏁�
	
	int rebAttNum; //杩涙敾绡澘鏁�
	int rebDefNum; //闃插畧绡澘鏁�
	int rebTotalNum; //鎬荤鏉挎暟
	
	int assistNum;//鍔╂敾鏁�
	int stealNum;//鎶㈡柇鏁�
    int blockNum;//鐩栧附鏁�
    int errorNum;//澶辫鏁�
    int foulNum;//鐘鏁�
	
    double shootrate;//鎶曠鍛戒腑鐜�
    double threepointrate;//涓夊垎鍛戒腑鐜�
    double freehitrate;//缃氱悆鍛戒腑鐜�
    double winrate;//鑳滅巼
    double attackround;//杩涙敾鍥炲悎
    double attackrate;//杩涙敾鏁堢巼
    double defendrate;//闃插畧鏁堢巼锛�
    double rebrate;//绡澘鏁堢巼锛�
    double stealrate;//鎶㈡柇鏁堢巼锛�
    double assistrate;//鍔╂敾鐜�
	//璧涘鎬绘暟
    
    
    //璧涘骞冲潎鏁�
  	int hitShootNumave; //鎶曠鍛戒腑鏁�
  	int shootNumave; //鎶曠鍑烘墜鏁�
  	
  	int threePointNumave; //涓夊垎鍛戒腑鏁�
  	int threeShootNumave; //涓夊垎鍑烘墜鏁�
  	
  	int freeHitNumave; //缃氱悆鍛戒腑鏁�
  	int freeNumave; //缃氱悆鍑烘墜鏁�
  	
  	int rebAttNumave; //杩涙敾绡澘鏁�
  	int rebDefNumave; //闃插畧绡澘鏁�
  	int rebTotalNumave; //鎬荤鏉挎暟
  	
  	int assistNumave;//鍔╂敾鏁�
  	int stealNumave;//鎶㈡柇鏁�
    int blockNumave;//鐩栧附鏁�
    int errorNumave;//澶辫鏁�
    int foulNumave;//鐘鏁�
  	
    double shootrateave;//鎶曠鍛戒腑鐜�
    double threepointrateave;//涓夊垎鍛戒腑鐜�
    double freehitrateave;//缃氱悆鍛戒腑鐜�
    double winrateave;//鑳滅巼
    double attackroundave;//杩涙敾鍥炲悎
    double attackrateave;//杩涙敾鏁堢巼
    double defendrateave;//闃插畧鏁堢巼锛�
    double rebrateave;//绡澘鏁堢巼锛�
    double stealrateave;//鎶㈡柇鏁堢巼锛�
    double assistrateave;//鍔╂敾鐜�
  	//璧涘骞冲潎鏁�
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
	public double getRebrate() {
		return rebrate;
	}
	public void setRebrate(double rebrate) {
		this.rebrate = rebrate;
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
	public double getRebrateave() {
		return rebrateave;
	}
	public void setRebrateave(double rebrateave) {
		this.rebrateave = rebrateave;
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

}
