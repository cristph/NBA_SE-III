package businesslogicservice.teamblservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Image;

import value.TeamStandard;
import value.Value.Order;
import vo.TeamGameVO;
import vo.TeamVO;

public interface TeamBLService {
	public TeamVO getTeamInfo(String name);
	
    public ArrayList<TeamGameVO> getTeamInOrder(Order order,TeamStandard stan);
    
    public HashMap<String,Image> getAllTeam();
}
