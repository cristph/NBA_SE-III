package data.teamdata;

import java.util.ArrayList;

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

	public ArrayList<TeamAllGamePO> getTeamGameData() {
		// TODO Auto-generated method stub
		return null;
	}

}
