package dataservice.teamdataservice;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamPO;

public interface TeamDataService {

	public ArrayList<TeamPO> getTeamData();
	public ArrayList<TeamAllGamePO> getTeamGameData();
	public HashMap<String,Image> getTeamImage();
}
