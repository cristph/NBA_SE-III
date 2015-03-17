package businesslogic.teambl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
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
	ArrayList<TeamAllGamePO> p=new ArrayList<TeamAllGamePO>();
	ArrayList<TeamPO> p2=new ArrayList<TeamPO>();
	ArrayList<TeamVO> pa=new ArrayList<TeamVO>();
	public TeamController(){
		p=t.getTeamGameData();
		p2=t.getTeamData();
		
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
    	return null;
    	
    }
    public TeamInfo getTeamInfo(String team, String date){
    	return null;
    }

}
