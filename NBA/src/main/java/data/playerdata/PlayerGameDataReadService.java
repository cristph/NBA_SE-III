package data.playerdata;

import java.util.HashMap;

import po.PlayerAllGamePO;

public interface PlayerGameDataReadService {

	public HashMap<String,PlayerAllGamePO> getPlayerGamePo();
}
