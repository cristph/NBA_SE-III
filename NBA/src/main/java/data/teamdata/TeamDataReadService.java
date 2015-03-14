package data.teamdata;

import java.util.ArrayList;

import po.TeamGamePO;
import po.TeamPO;

public interface TeamDataReadService {

	public TeamPO getTeamPo(String teamName);
	public ArrayList<TeamGamePO> getTeamGamePo();
}
