package dataservice.teamdataservice;

import java.util.ArrayList;

import po.TeamGamePO;
import po.TeamPO;

public interface TeamDataService {

	public ArrayList<TeamPO> getTeamData();
	public ArrayList<TeamGamePO> getTeamGameData();
}
