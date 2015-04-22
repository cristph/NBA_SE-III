package data.funddata;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.PlayerPO;
import po.TeamPO;

public interface FundDataService {

	public ArrayList<TeamPO> getTeamFundData();
	public HashMap<String, Image> getTeamImage();
	public ArrayList<PlayerPO> getPlayerFundData();
	
}
