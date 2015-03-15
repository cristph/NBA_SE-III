package data.teamdata;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamGamePO;
import po.TeamPO;

public interface TeamDataReadService {

	public ArrayList<TeamPO> getTeamPo();
	public ArrayList<TeamGamePO> getTeamGamePo();
	public HashMap<String,Image> getTeamImage();
}
