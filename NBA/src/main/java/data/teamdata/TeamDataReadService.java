package data.teamdata;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import po.TeamPO;

public interface TeamDataReadService {

	public ArrayList<TeamPO> getTeamPo();
	public HashMap<String,Image> getTeamImage();
}
