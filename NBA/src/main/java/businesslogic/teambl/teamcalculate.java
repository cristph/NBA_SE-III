package businesslogic.teambl;

import po.TeamAllGamePO;
import po.TeamGamePO;

import java.util.*;
public class teamcalculate {
	public int getgamenum(TeamAllGamePO p){
		ArrayList<TeamGamePO> tgp=p.getGameDataList();		
		return tgp.size();
	}
	//总数据
    public int getHitshootnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getHitShootNum();
		}
		return all;
	}
	public int getshootnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getShootNum();
		}
		return all;
	}
	public int getthreepointnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getThreePointNum();
		}
		return all;
	}
	public int getthreeshootnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getThreeShootNum();
		}
		return all;
	}
	public int getfreehitnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getFreeHitNum();
		}
		return all;
	}
	public int getfreenum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getFreeNum();
		}
		return all;
	}
	public int getrebattnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getRebAttNum();
		}
		return all;
	}
	public int getrebdefnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getRebDefNum();
		}
		return all;
	}
	public int getrebtotalnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getRebTotalNum();
		}
		return all;
	}
	public int getassistnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getAssistNum();
		}
		return all;
	}
	public int getstealnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getStealNum();
		}
		return all;
	}
	public int getblocknum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getBlockNum();
		}
		return all;
	}
	public int geterrornum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getErrorNum();
		}
		return all;
	}
	public int getfoulnum(TeamAllGamePO p){
		int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			all=all+tgp.getFoulNum();
		}
		return all;
	}
	public double getshootrate (TeamAllGamePO p){
		double result=1.0*(getHitshootnum(p)/getshootnum(p));
		return result;
	
	}
	public double getthreepointrate(TeamAllGamePO p){
		double result=1.0*(getthreepointnum(p)/getthreeshootnum(p));
		return result;
	}
	public double getfreeshootrate(TeamAllGamePO p){
		double result=1.0*(getfreehitnum(p)/getfreenum(p));
		return result;
	}
    public double getwinrate(TeamAllGamePO p){
    	int win=0;
    	for(TeamGamePO tgp:p.getGameDataList()){
    		String result=tgp.getMatchResult();
    		String[] result2=result.split(":");
    		if(Integer.parseInt(result2[0])>Integer.parseInt(result2[1])){
    			win=win+1;
    		}
    	}
    	double d=1.0*(win/getgamenum(p));
    	return d;
    }
    /*public double getattackround(TeamAllGamePO p){
    	double round=0;
    	for(TeamGamePO tgp:p.getGameDataList()){
    		double d=tgp.getShootNum()+0.4*tgp.getFreeNum()-1.07*(tgp.getRebAttNum()/(tgp.getRebAttNum()
    				+tgp.getOppDefNum())*(tgp.getShootNum()-tgp.getHitShootNum()))+1.07*tgp.getErrorNum(); 
    		round=round+d;		
    	}
    	return round;
    }//可能会要转换成double*/
    public double getoppattround(TeamAllGamePO p){
    	return 0;
    }
    public double getallpoint(TeamAllGamePO p){
    	int all=0;
    	for(TeamGamePO tgp: p.getGameDataList()){
    		String result=tgp.getMatchResult();
    		String[] result2=result.split(":");
    		all=all+Integer.parseInt(result2[0]);
    	}
    	return all;
    }
    public double getattrate(TeamAllGamePO p){
    	double d1=getallpoint(p)*1.0;
    	//double d2=getattackround(p);
    	double rate=d1;///(d2/100);
    	return rate;
    }
    public double getdefrate(TeamAllGamePO p){
    	return 0;
    }
    public int getoppattreb(TeamAllGamePO p){
    	int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			//all=all+tgp.getOppAttNum();
		}
		return all;
    }
    public int getoppdefreb(TeamAllGamePO p){
    	int all=0;
		for(TeamGamePO tgp:p.getGameDataList()){
			//all=all+tgp.getOppDefNum();
		}
		return all;
    }
    public double attrebrate(TeamAllGamePO p){
    	return (getrebattnum(p)*1.0)/((getrebattnum(p)+getoppdefreb(p))*1.0);
    }
    public double defrearate(TeamAllGamePO p){
    	return (getrebdefnum(p)*1.0)/((getrebdefnum(p)+getoppattreb(p))*1.0);
    }
    public double getstealrate(TeamAllGamePO p){
    	return 0;
    }
    public double getassistrate(TeamAllGamePO p){
    	return (getassistnum(p)*1.0);//(getattackround(p)/100);
    }
}
