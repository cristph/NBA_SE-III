package data.teamdata;

import java.util.ArrayList;

import po.TeamGamePO;
import po.TeamPO;

public interface TeamDataReadService {

	public ArrayList<TeamPO> getTeamPo();
	public ArrayList<TeamGamePO> getTeamGamePo();
}
