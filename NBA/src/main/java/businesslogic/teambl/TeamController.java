package businesslogic.teambl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamGamePO;
import po.TeamPO;
import data.teamdata.TeamData;
import dataservice.teamdataservice.TeamDataService;
import value.TeamStandard;
import value.Value.Order;
import vo.TeamGameVO;
import vo.TeamVO;
import businesslogicservice.teamblservice.TeamBLService;
import businesslogicservice.teamblservice.TeamInfoProvider;

public class TeamController implements TeamBLService, TeamInfoProvider{
	
	TeamDataService t=new TeamData();
	teamcalculate cal=new teamcalculate();
	ArrayList<TeamAllGamePO> po=new ArrayList<TeamAllGamePO>();
	ArrayList<TeamPO> p2=new ArrayList<TeamPO>();
	ArrayList<TeamVO> pa=new ArrayList<TeamVO>();
	public TeamController(){
		po=t.getTeamGameData();
		p2=t.getTeamData();
		for(TeamPO p:p2){
			TeamVO v=new TeamVO();
			TeamAllGamePO thisteam=new TeamAllGamePO();
			for(TeamAllGamePO i:po){
				if(i.getTeamName().equals(p.getTeamName())){
					thisteam.setGameDataList(i.getGameDataList());
				}
			}
			thisteam.setTeamName(p.getTeamName());
			TeamAllGamePO oppteam=getoppgamedata(thisteam);
			v.setTeamName(p.getTeamName());
			v.setShortName(p.getShortName());
			v.setLocation(p.getLocation());
			v.setCompArea(p.getCompArea());
			v.setZone(p.getZone());
			v.setHome(p.getHome());
			v.setBirthday(p.getBirthday());
			
			v.setTeamPic(p.getTeamPic());
			
			v.setGamenum(cal.getgamenum(thisteam));
			
			
			v.setAllpoint(cal.getallpoint(thisteam));
			
			v.setHitShootNum(cal.getHitshootnum(thisteam));
			v.setShootNum(cal.getshootnum(thisteam));
			
			v.setThreePointNum(cal.getthreepointnum(thisteam));
			v.setThreeShootNum(cal.getthreeshootnum(thisteam));
			
			v.setFreeHitNum(cal.getthreeshootnum(thisteam));
			v.setFreeNum(cal.getfreenum(thisteam));
			
			v.setRebAttNum(cal.getrebattnum(thisteam));
			v.setRebDefNum(cal.getrebdefnum(thisteam));
			v.setRebTotalNum(cal.getrebtotalnum(thisteam));
			
			v.setAssistNum(cal.getassistnum(thisteam));
			v.setStealNum(cal.getstealnum(thisteam));
			v.setBlockNum(cal.getblocknum(thisteam));
			v.setErrorNum(cal.geterrornum(thisteam));
			v.setFoulNum(cal.getfoulnum(thisteam));
		    
		    v.setShootrate(cal.getshootrate(thisteam));
		    v.setThreepointrate(cal.getthreepointrate(thisteam));
		    v.setFreehitrate(cal.getfreeshootrate(thisteam));
		    v.setWinrate(cal.getwinrate(thisteam));
		    v.setAttackround(cal.getattackround(thisteam, oppteam));
		    v.setAttackrate(cal.getattrate(thisteam, oppteam));
		    v.setDefendrate(cal.getdefrate(thisteam, oppteam));
		    v.setRebattrate(cal.attrebrate(thisteam, oppteam));
		    v.setRebdefrate(cal.defrebrate(thisteam, oppteam));
		    v.setStealrate(cal.getstealrate(thisteam, oppteam));
		    v.setAssistrate(cal.getassistrate(thisteam, oppteam));
		    
		    
		    v.setAllpointave(cal.getavepoint(thisteam));
		    
		  	v.setHitShootNumave(cal.getavehitshootnum(thisteam)); 
		  	v.setShootNumave(cal.getaveshootnum(thisteam));
		  	
		  	v.setThreePointNumave(cal.getavethreepointnum(thisteam));
		  	v.setThreeShootNumave(cal.getavethreeshootnum(thisteam));
		  	
		  	v.setFreeHitNumave(cal.getavefreehitnum(thisteam));
		  	v.setFreeNumave(cal.getavefreenum(thisteam));
		  	
		  	v.setRebAttNumave(cal.getaverebattnum(thisteam));
		  	v.setRebDefNumave(cal.getaverebdefnum(thisteam));
		  	v.setRebTotalNumave(cal.getaverebtotalnum(thisteam));
		  	
		  	v.setAssistNumave(cal.getaveassistnum(thisteam));
		  	v.setStealNumave(cal.getavestealnum(thisteam));
		  	v.setBlockNumave(cal.getaveblocknum(thisteam));
		  	v.setErrorNumave(cal.getaveerrornum(thisteam));
		  	v.setFoulNumave(cal.getavefoulnum(thisteam));
		  	pa.add(v);
		}
	}
    public TeamVO getTeamInfo(String name){
    	TeamVO result=new TeamVO();
    	for(TeamVO v:pa){
    		if(v.getTeamName().equals(name)){
    			result=v;
    			break;
    		}
    	}
    	return result;
    }
	
    public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan){
    	return null;
    }
    
    public HashMap<String,Image> getAllTeam(){
    	return t.getTeamImage();
    }
    public TeamAllGamePO getoppgamedata(TeamAllGamePO p){
    	ArrayList<TeamGamePO> tgp=p.getGameDataList();
    	ArrayList<TeamGamePO> tgp2=new ArrayList<TeamGamePO>();
    	for(TeamGamePO tp:tgp){
    		String[] team=tp.getMatchPair().split(":");
    		String time=tp.getMatchDate();
    		for(TeamAllGamePO tagp:po){
    			if(tagp.getTeamName().equals(team[1])){
    				for(TeamGamePO tp2:tagp.getGameDataList()){
    					if(tp2.getMatchDate().equals(time)){
    						tgp2.add(tp2);
    					}
    				}
    			}
    		}
    	}
    	TeamAllGamePO result=new TeamAllGamePO();
    	result.setTeamName(p.getTeamName());
    	result.setGameDataList(tgp2);
    	return result;
    	
    }
    public TeamInfo getTeamInfo(String team, String date){
    	TeamAllGamePO thisteam=new TeamAllGamePO();
    	TeamAllGamePO oppteam=new TeamAllGamePO();
    	
    	for(TeamAllGamePO p:po){
    		if(p.getTeamName().equals(team)){
    			thisteam=p;
    			break;
    		}
    	}
    	oppteam=getoppgamedata(thisteam);
    	ArrayList<TeamGamePO> thist=new ArrayList<TeamGamePO>();
    	ArrayList<TeamGamePO> oppt=new ArrayList<TeamGamePO>();
    	thist=thisteam.getGameDataList();
    	oppt=oppteam.getGameDataList();
    	
    	
    	return null;
    }

}
