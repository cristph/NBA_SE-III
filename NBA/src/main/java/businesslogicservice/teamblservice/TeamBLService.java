package businesslogicservice.teamblservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Image;

import po.TeamGamePO;
import po.TeamPO;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import value.TeamStandard;
import value.Value.Field2;
import value.Value.Order;
import vo.DateGameVO;

public interface TeamBLService {
	//public TeamVO getTeamInfo(String name);
	
    //public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan);
    
    public HashMap<String,Image> getAllTeam();
    public ArrayList<TeamHotInfo> getHotTeam(Field2 field2,int num);
    //得到热点球队信息，field2为筛选热门球队的属性，num为返回的球队数
     
     
     
	public ArrayList<TeamHighInfo> getTeamHighInfo(TeamStandard ts,Order order,int num);
	//得到球队高级数据，均为平均值，teamstandard为排序依据，order为升降序，num为要的数目
	
	
	public ArrayList<TeamNormalInfo> getTeamavgNormalInfo(TeamStandard ts,Order order,int num);
	//得到球队基本数据的平均值，ts为排序依据，order为升降序，num为数目
	
	
	public ArrayList<TeamNormalInfo> getTeamTotalNormalInfo(TeamStandard ts,Order order,int num);
	//得到球队基本数据的总和，ts为排序依据，order为升降序，num为数目
	
	
	public TeamPO getTeamInfo(String name);
	//得到球队基本信息
	
	public ArrayList<TeamGamePO> getGameInfo(String time,String matchpair);
	
	//得到某一场比赛数据
	public ArrayList<DateGameVO> getGamebyDate(String time);
	//得到某一日期的数据
	public TeamNormalInfo getSingleTeamNormalInfo(String name);
	//得到一支球队的基本信息，为平均值
	
	public TeamHighInfo getSingleTeamHighInfo(String name);
	//得到一支球队的高级数据，为平均值
	public ArrayList<DateGameVO> getRecentGame (String name);
	public void setSeason(String seasonwant);
	//得到一支球队的最近5场比赛信息
}
