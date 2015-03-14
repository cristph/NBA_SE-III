package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import po.PlayerGamePO;
import po.PlayerPO;

public class PlayerDataReader implements PlayerDataReadService {

	public PlayerPO getPlayerPo(String path) {
		// TODO Auto-generated method stub
		PlayerPO result=new PlayerPO();
		
		try {
			FileReader inOne=new FileReader(new File(path));
			BufferedReader inTwo=new BufferedReader(inOne);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public HashMap<String, PlayerGamePO> getPlayerGamePo() {
		// TODO Auto-generated method stub
		return null;
	}

}
