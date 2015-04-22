package data.gamedata;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;

public interface GameDataService {

	public ArrayList<PlayerAllGamePO> getPlayerGameData();
	public ArrayList<TeamAllGamePO> getTeamGameData();
	public ArrayList<PlayerGamePO> get_Latest_PlayerGameData();
}
