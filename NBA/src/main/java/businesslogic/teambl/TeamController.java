package businesslogic.teambl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamGamePO;
import po.TeamPO;
import data.teamdata.TeamData;
import dataservice.teamdataservice.TeamDataService;
import value.TeamStandard;
import value.Value.Order;
import vo.TeamGameVO;
import vo.TeamVO;
import businesslogicservice.teamblservice.TeamBLService;
import businesslogicservice.teamblservice.TeamInfoProvider;

public class TeamController implements TeamBLService, TeamInfoProvider{
	
	TeamDataService t=new TeamData();
	teamcalculate cal=new teamcalculate();
	ArrayList<TeamAllGamePO> po=new ArrayList<TeamAllGamePO>();
	ArrayList<TeamPO> p2=new ArrayList<TeamPO>();
	ArrayList<TeamVO> pa=new ArrayList<TeamVO>();
	public TeamController(){
		po=t.getTeamGameData();
		p2=t.getTeamData();
		for(TeamPO p:p2){
			TeamVO v=new TeamVO();
			TeamAllGamePO thisteam=new TeamAllGamePO();
			for(TeamAllGamePO i:po){
				if(i.getTeamName().equals(p.getTeamName())){
					thisteam.setGameDataList(i.getGameDataList());
				}
			}
			thisteam.setTeamName(p.getTeamName());
			TeamAllGamePO oppteam=getoppgamedata(thisteam);
			v.setTeamName(p.getTeamName());
			v.setShortName(p.getShortName());
			v.setLocation(p.getLocation());
			v.setCompArea(p.getCompArea());
			v.setZone(p.getZone());
			v.setHome(p.getHome());
			v.setBirthday(p.getBirthday());
			
			v.setTeamPic(p.getTeamPic());
			
			v.setGamenum(cal.getgamenum(thisteam));
			
			
			v.setAllpoint(cal.getallpoint(thisteam));
			
			v.setHitShootNum(cal.getHitshootnum(thisteam));
			v.setShootNum(cal.getshootnum(thisteam));
			
			v.setThreePointNum(cal.getthreepointnum(thisteam));
			v.setThreeShootNum(cal.getthreeshootnum(thisteam));
			
			v.setFreeHitNum(cal.getthreeshootnum(thisteam));
			v.setFreeNum(cal.getfreenum(thisteam));
			
			v.setRebAttNum(cal.getrebattnum(thisteam));
			v.setRebDefNum(cal.getrebdefnum(thisteam));
			v.setRebTotalNum(cal.getrebtotalnum(thisteam));
			
			int assistNum;//助攻数
			int stealNum;//抢断数
		    int blockNum;//盖帽数
		    int errorNum;//失误数
		    int foulNum;//犯规数
		    
		    double shootrate;//投篮命中率
		    double threepointrate;//三分命中率
		    double freehitrate;//罚球命中率
		    double winrate;//胜率
		    double attackround;//进攻回合
		    double attackrate;//进攻效率
		    double defendrate;//防守效率
		    double rebattrate;//进攻篮板效率
		    double rebdefrate;//防守篮板效率
		    double stealrate;//抢断效率
		    double assistrate;//助攻率
		    
		    
		    int allpointave;//平均得分
		    
		  	int hitShootNumave; //投篮命中数
		  	int shootNumave; //投篮出手数
		  	
		  	int threePointNumave; //三分命中数
		  	int threeShootNumave; //三分出手数
		  	
		  	int freeHitNumave; //罚球命中数
		  	int freeNumave; //罚球出手数
		  	
		  	int rebAttNumave; //进攻篮板数
		  	int rebDefNumave; //防守篮板数
		  	int rebTotalNumave; //总篮板数
		  	
		  	int assistNumave;//助攻数
		  	int stealNumave;//抢断数
		    int blockNumave;//盖帽数
		    int errorNumave;//失误数
		    int foulNumave;//犯规数
		}
	}
    public TeamVO getTeamInfo(String name){
    	TeamVO result=new TeamVO();
    	for(TeamVO v:pa){
    		if(v.getTeamName().equals(name)){
    			result=v;
    			break;
    		}
    	}
    	return result;
    }
	
    public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan){
    	return null;
    }
    
    public HashMap<String,Image> getAllTeam(){
    	return t.getTeamImage();
    }
    public TeamAllGamePO getoppgamedata(TeamAllGamePO p){
    	ArrayList<TeamGamePO> tgp=p.getGameDataList();
    	ArrayList<TeamGamePO> tgp2=new ArrayList<TeamGamePO>();
    	for(TeamGamePO tp:tgp){
    		String[] team=tp.getMatchPair().split(":");
    		String time=tp.getMatchDate();
    		for(TeamAllGamePO tagp:po){
    			if(tagp.getTeamName().equals(team[1])){
    				for(TeamGamePO tp2:tagp.getGameDataList()){
    					if(tp2.getMatchDate().equals(time)){
    						tgp2.add(tp2);
    					}
    				}
    			}
    		}
    	}
    	TeamAllGamePO result=new TeamAllGamePO();
    	result.setTeamName(p.getTeamName());
    	result.setGameDataList(tgp2);
    	return result;
    	
    }
    public TeamInfo getTeamInfo(String team, String date){
    	return null;
    }

}
