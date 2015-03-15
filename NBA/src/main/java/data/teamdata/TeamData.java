package data.teamdata;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamPO;
import dataservice.teamdataservice.TeamDataService;

public class TeamData implements TeamDataService {

	public ArrayList<TeamPO> getTeamData() {
		// TODO Auto-generated method stub
		TeamDataReadService tdrs=new TeamDataReader();
		ArrayList<TeamPO> list=tdrs.getTeamPo();
		
		return list;
	}

	public HashMap<String, Image> getTeamImage() {
		// TODO Auto-generated method stub
		TeamDataReadService tdrs=new TeamDataReader();
		HashMap<String,Image> result=tdrs.getTeamImage();
		return result;
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
