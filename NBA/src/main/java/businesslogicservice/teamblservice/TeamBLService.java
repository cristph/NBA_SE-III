package businesslogicservice.teamblservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Image;

import po.TeamPO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import value.PlayerStandard;
import value.TeamStandard;
import value.Value.Age;
import value.Value.Field;
import value.Value.Field2;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import vo.PlayerVO;
import vo.TeamVO;

public interface TeamBLService {
	//public TeamVO getTeamInfo(String name);
	
    //public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan);
    
    public HashMap<String,Image> getAllTeam();
    public ArrayList<TeamHotInfo> getHotTeam(Field2 field2,int num);
	public ArrayList<TeamHighInfo> getTeamHighInfo(TeamStandard ts,Order order,int num);
	
	
	
	public ArrayList<TeamNormalInfo> getTeamavgNormalInfo(TeamStandard ts,Order order,int num);
	
	
	
	public ArrayList<TeamNormalInfo> getTeamTotalNormalInfo(TeamStandard ts,Order order,int num);
	
	
	
	public TeamPO getTeamInfo(String name);
	
	
	
	public PlayerNormalInfo getSinglePlayerNormalInfo(String name);
	
	
	
	public PlayerHighInfo getSinglePlayerHighInfo(String name);
}
