package dataservice.playerdataservice;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerPO;

public interface PlayerDataService {

	public ArrayList<PlayerPO> getPlayerData();
	public ArrayList<PlayerAllGamePO> getPlayerGameData();
}
