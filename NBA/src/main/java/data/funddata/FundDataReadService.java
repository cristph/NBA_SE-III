package data.funddata;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import po.PlayerPO;
import po.TeamPO;

public interface FundDataReadService {

	public ArrayList<TeamPO> readTeamFile(File txtFile,File imgFold);
	public HashMap<String,Image> readTeamImgFile(File imgFold);
	public PlayerPO readPlayerFile(File f,String acImgPath,String porImgPath);
}
