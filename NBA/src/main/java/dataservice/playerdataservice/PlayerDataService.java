package dataservice.playerdataservice;

import java.util.ArrayList;

import po.PlayerGamePO;
import po.PlayerPO;

public interface PlayerDataService {

	public ArrayList<PlayerPO> getPlayerData();
	public ArrayList<PlayerGamePO> getPlayerGameData();
}
