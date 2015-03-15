package businesslogic.teambl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import data.teamdata.TeamData;
import dataservice.teamdataservice.TeamDataService;
import value.TeamStandard;
import value.Value.Order;
import vo.TeamVO;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamController implements TeamBLService{
	
	TeamDataService t=new TeamData();
    public TeamVO getTeamInfo(String name){
    	return null;
    }
	
    public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan){
    	return null;
    }
    
    public HashMap<String,Image> getAllTeam(){
    	return t.getTeamImage();
    }

}
