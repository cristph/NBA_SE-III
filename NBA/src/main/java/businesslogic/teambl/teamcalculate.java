package businesslogic.teambl;

import po.TeamAllGamePO;
import po.TeamGamePO;

import java.util.*;
public class teamcalculate {
	public int getgamenum(TeamAllGamePO p){
		ArrayList<TeamGamePO> tgp=p.getGameDataList();		
		return tgp.size();
	}
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

}
