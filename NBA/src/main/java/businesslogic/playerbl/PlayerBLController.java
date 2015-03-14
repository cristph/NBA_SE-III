package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerAllGamePO;

public class PlayerBLController {
	
	IniData iniData;
	ArrayList<PlayerAllGamePO> pGameList;
	
	public PlayerBLController(){
		
		iniData=new IniData();
	}
	
}
