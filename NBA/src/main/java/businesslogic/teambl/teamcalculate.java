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
		double result=0;
		if(getshootnum(p)==0){
			
		}
		else{
			result=1.0*(getHitshootnum(p)/getshootnum(p));
		}
		return result;
	
	}
	public double getthreepointrate(TeamAllGamePO p){
		double result=0;
		if(getthreeshootnum(p)==0){
			
		}
		else{
			result=1.0*(getthreepointnum(p)/getthreeshootnum(p));
		}
		return result;
	}
	public double getfreeshootrate(TeamAllGamePO p){
		double result=0;
		if(getfreenum(p)==0){
			
		}
		else{
			result=1.0*(getfreehitnum(p)/getfreenum(p));
		}
		return result;
	}
    public double getwinrate(TeamAllGamePO p){
    	int win=0;
    	for(TeamGamePO tgp:p.getGameDataList()){
    		String result=tgp.getMatchResult();
    		String[] result2=result.split("-");
    		if(Integer.parseInt(result2[0])>Integer.parseInt(result2[1])){
    			win=win+1;
    		}
    	}
    	double d=1.0*(win/getgamenum(p));
    	return d;
    }
    public double getattackround(TeamAllGamePO p,TeamAllGamePO p2){
    	double round=0;
    	//System.out.println(p.getGameDataList().size());
    	for(TeamGamePO tgp:p.getGameDataList()){
    		//System.out.println(p.getGameDataList().indexOf(tgp));
    		double d=tgp.getShootNum()+0.4*tgp.getFreeNum()-1.07*(tgp.getRebAttNum()/(1.0*tgp.getRebAttNum()
    				+1.0*p2.getGameDataList().get(p.getGameDataList().indexOf(tgp)).getRebDefNum())*(1.0*tgp.getShootNum()-1.0*tgp.getHitShootNum()))+1.07*tgp.getErrorNum(); 
    		round=round+d;		
    	}
    	//System.out.println("qwe");
    	return round;
    }//可能会要转换成double
    
    public int getallpoint(TeamAllGamePO p){
    	int all=0;
    	for(TeamGamePO tgp: p.getGameDataList()){
    		String result=tgp.getMatchResult();
    		String[] result2=result.split("-");
    		all=all+Integer.parseInt(result2[0]);
    	}
    	return all;
    }
    public double getattrate(TeamAllGamePO p,TeamAllGamePO p2){
    	double d1=getallpoint(p)*1.0;
    	double d2=getattackround(p,p2);
    	double rate=d1/(d2/100);
    	return rate;
    }
    public double getdefrate(TeamAllGamePO p,TeamAllGamePO p2){
    	//System.out.println(p2.getGameDataList().size());
    	double d1=getattackround(p2,p);
    	double d2=getallpoint(p2)*1.0;
    	double rate=d2/(d1/100);
    	return rate;
    }
    /*public int getoppattreb(TeamAllGamePO p){
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
    }*/
    public double attrebrate(TeamAllGamePO p,TeamAllGamePO p2){
    	return (getrebattnum(p)*1.0)/((getrebattnum(p)+getrebdefnum(p2))*1.0);
    }
    public double defrebrate(TeamAllGamePO p,TeamAllGamePO p2){
    	return (getrebdefnum(p)*1.0)/((getrebdefnum(p)+getrebattnum(p2))*1.0);
    }
    public double getstealrate(TeamAllGamePO p,TeamAllGamePO p2){
    	
    	return (getstealnum(p)*1.0)/(getattackround(p,p2)/100);
    }
    public double getassistrate(TeamAllGamePO p,TeamAllGamePO p2){//p2为不同对手对应每场比赛数据
    	return (getassistnum(p)*1.0)/(getattackround(p2,p)/100);
    }
    //总数据
    
    
    
    //平均数据
    public double getavepoint(TeamAllGamePO p){
    	return ((getallpoint(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavehitshootnum(TeamAllGamePO p){
    	return ((getHitshootnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaveshootnum(TeamAllGamePO p){
    	return ((getshootnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavethreepointnum(TeamAllGamePO p){
    	return ((getthreepointnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavethreeshootnum(TeamAllGamePO p){
    	return ((getthreeshootnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavefreehitnum(TeamAllGamePO p){
    	return ((getfreehitnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavefreenum(TeamAllGamePO p){
    	return ((getfreenum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaverebattnum(TeamAllGamePO p){
    	return ((getrebattnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaverebdefnum(TeamAllGamePO p){
    	return ((getrebdefnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaverebtotalnum(TeamAllGamePO p){
    	return ((getrebtotalnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaveassistnum(TeamAllGamePO p){
    	return ((getassistnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavestealnum(TeamAllGamePO p){
    	return ((getstealnum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaveblocknum(TeamAllGamePO p){
    	return ((getblocknum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getaveerrornum(TeamAllGamePO p){
    	return ((geterrornum(p)*1.0)/(1.0*getgamenum(p)));
    }
    public double getavefoulnum(TeamAllGamePO p){
    	return ((getfoulnum(p)*1.0)/(1.0*getgamenum(p)));
    }
}
