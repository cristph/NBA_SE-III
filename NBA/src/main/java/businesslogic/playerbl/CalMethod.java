package businesslogic.playerbl;

public class CalMethod {
	
	public double calT(int time,int allPlayerTime){
		return (1.0*(allPlayerTime/5)/time);
	}
	
	public double calRate(int sample,int sum){
		return (1.0*sample/sum);
	}
	
	public double calEfficiency(int rebTotalNum, int assistNum, int stealNum,
			int blockNum, int errorNum, int score, 
			int hitShootNum, int shootNum, int freeHitNum,int freeNum){
		return 1.0*((score+rebTotalNum+assistNum+assistNum+blockNum)
				-(shootNum-hitShootNum)-(freeNum-freeHitNum)-errorNum);
	}
	
	public double calGmScEfficiency(int rebAttNum, int rebDefNum, int assistNum, int stealNum,
			int blockNum, int errorNum, int foulNum, int score, 
			int hitShootNum, int shootNum, int freeHitNum,int freeNum){
		return 1.0*(score+0.4*hitShootNum-0.7*shootNum-0.4*(freeNum-freeHitNum)
				+0.7*rebAttNum+0.3*rebDefNum+stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-errorNum);
	}
	
	public double calRealHitRate(int score, int shootNum, int freeNum){
		return 1.0*score/(2*(shootNum+0.44*freeNum));
	}
	
	public double calThrowRate(int hitShootNum, int shootNum, int threePointNum){
		return  1.0*(hitShootNum+0.5*threePointNum)/shootNum;
	}
	
	public double calRebRate(int rebTotalNum, double T, int teamRebNum, int oppTeamRebNum){
		return 1.0*rebTotalNum*T/(teamRebNum+oppTeamRebNum);
	}
	
	public double calAssistRate(int assistNum, int teamHitNum, int hitShootNum, double T){
		return 1.0*assistNum/((1/T)*teamHitNum-hitShootNum);
	}
	
	public double calStealRate(int stealNum, int oppAttNum, double T){
		return 1.0*stealNum*T/oppAttNum;
	}
	
	public double calBlockRate(int blockNum, int oppTwoNum, double T){
		return 1.0*blockNum*T/oppTwoNum;
	}
	
	public double calErrorRate(int errorNum, int twoNum, int freeNum){
		return 1.0*errorNum/(twoNum+0.44*freeNum+errorNum);
	}
	
	public double calUseRate(int shootNum, int freeNum, int errorNum, double T, 
			int teamThrowNum, int teamFreeNum, int teamErrorNum){
		return 1.0*(shootNum+0.44*freeNum+errorNum)*T/(teamThrowNum+0.44*teamFreeNum+teamErrorNum);
	}
}
