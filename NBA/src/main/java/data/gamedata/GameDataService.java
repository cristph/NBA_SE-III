package data.gamedata;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;

public interface GameDataService {

	public ArrayList<PlayerAllGamePO> getPlayerGameData(Selector st);
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st);
	public ArrayList<PlayerGamePO> get_Latest_PlayerGameData();
	public ArrayList<PlayerGamePO> getPlayerGameData_BySeason(PlayerChoosor pcs);
}
