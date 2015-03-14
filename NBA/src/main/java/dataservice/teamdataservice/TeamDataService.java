package dataservice.teamdataservice;

import java.util.ArrayList;

import po.TeamAllGamePO;
import po.TeamPO;

public interface TeamDataService {

	public ArrayList<TeamPO> getTeamData();
	public ArrayList<TeamAllGamePO> getTeamGameData();
}
