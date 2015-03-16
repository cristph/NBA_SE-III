package data.teamdata;

import java.util.HashMap;

import po.TeamAllGamePO;

public interface TeamGameDataReadService {

	public HashMap<String,TeamAllGamePO> getTeamAllGamePo();
}
