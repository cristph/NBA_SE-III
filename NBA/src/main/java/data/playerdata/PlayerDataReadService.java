package data.playerdata;

import java.util.HashMap;

import po.PlayerGamePO;
import po.PlayerPO;

public interface PlayerDataReadService {

	public PlayerPO getPlayerPo(String name);
	public HashMap<String,PlayerGamePO> getPlayerGamePo();

}
