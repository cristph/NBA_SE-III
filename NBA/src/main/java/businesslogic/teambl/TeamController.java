package businesslogic.teambl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamGamePO;
import po.TeamPO;
import data.funddata.FundData;
import data.funddata.FundDataService;
import data.gamedata.GameData;
import data.gamedata.GameDataService;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import value.TeamStandard;
import value.Value.Field2;
import value.Value.Order;
import vo.DateGameVO;
import vo.TeamVO;
import businesslogic.teambl.teamcalculate;
import businesslogic.teambl.teamsearch;
import businesslogicservice.teamblservice.TeamBLService;


public class TeamController implements TeamBLService{
	teamsearch ts=new teamsearch();
	
	FundDataService fd=new FundData();
	GameDataService gd=new GameData();
	teamcalculate cal=new teamcalculate();
	ArrayList<TeamAllGamePO> po=new ArrayList<TeamAllGamePO>();
	ArrayList<TeamPO> p2=new ArrayList<TeamPO>();
	ArrayList<TeamVO> pa=new ArrayList<TeamVO>();
	public void getTeamVO(){
		//int count=0;
		pa=new ArrayList<TeamVO>();
		po=gd.getTeamGameData();
		p2=fd.getTeamFundData();
		for(TeamAllGamePO pagp:po){
			//System.out.println("__________________________________________");
			for(int i=0;i<pagp.getGameDataList().size();i++){
				TeamGamePO pp=pagp.getGameDataList().get(i);
				//System.out.println(pagp.getGameDataList().size());
				if(pp.getIsDirty()==true){
					//System.out.println(pp.getMatchPair()+pp.getMatchDate()+pagp.getTeamName());
					pagp.getGameDataList().remove(pp);
					i=i-1;
				}
			}
		}
		//System.out.println("__________________________________________");
		//for(TeamAllGamePO ppp:po){
			//System.out.println(ppp.getTeamName()+ppp.getGameDataList().size());
			
				//System.out.println(ppp.getGameDataList().size());
				//for(TeamGamePO pq:ppp.getGameDataList()){
					//System.out.println(pq.getMatchPair()+pq.getMatchDate());
				//}
			
		//}
		//System.out.println("_____________");
		for(TeamPO p:p2){
			TeamVO v=new TeamVO();
			//System.out.println("ok");
			TeamAllGamePO thisteam=new TeamAllGamePO();
			for(TeamAllGamePO i:po){
				if(i.getTeamName().equals(p.getShortName())){
					//System.out.println("opp");
					thisteam=i;//.setGameDataList(i.getGameDataList());
				}
			}
			//thisteam.setTeamName(p.getTeamName());
			TeamAllGamePO oppteam=getoppgamedata(thisteam);
			
			//System.out.println(thisteam.getGameDataList().size());
			v.setTeamName(p.getTeamName());
			v.setShortName(p.getShortName());
			v.setLocation(p.getLocation());
			v.setCompArea(p.getCompArea());
			v.setZone(p.getZone());
			v.setHome(p.getHome());
			v.setBirthday(p.getBirthday());
			
			v.setTeamPic(p.getTeamPic());
			
			v.setGamenum(cal.getgamenum(thisteam));
			
			//System.out.println(p.getShortName()+cal.getgamenum(thisteam)+oppteam.getGameDataList().size());
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
			
			v.setAssistNum(cal.getassistnum(thisteam));
			v.setStealNum(cal.getstealnum(thisteam));
			v.setBlockNum(cal.getblocknum(thisteam));
			v.setErrorNum(cal.geterrornum(thisteam));
			v.setFoulNum(cal.getfoulnum(thisteam));
		    
		    v.setShootrate(cal.getshootrate(thisteam));
		    v.setThreepointrate(cal.getthreepointrate(thisteam));
		    v.setFreehitrate(cal.getfreeshootrate(thisteam));
		    v.setWinrate(cal.getwinrate(thisteam));//System.out.println(cal.getwinrate(thisteam)+"as");
		    v.setAttackround(cal.getattackround(thisteam, oppteam));
		    v.setAttackrate(cal.getattrate(thisteam, oppteam));
		    v.setDefendrate(cal.getdefrate(thisteam, oppteam));
		    v.setRebattrate(cal.attrebrate(thisteam, oppteam));
		    v.setRebdefrate(cal.defrebrate(thisteam, oppteam));
		    v.setStealrate(cal.getstealrate(thisteam, oppteam));
		    v.setAssistrate(cal.getassistrate(thisteam, oppteam));
		    
		    
		    v.setAllpointave(cal.getavepoint(thisteam));
		    
		  	v.setHitShootNumave(cal.getavehitshootnum(thisteam)); 
		  	v.setShootNumave(cal.getaveshootnum(thisteam));
		  	
		  	v.setThreePointNumave(cal.getavethreepointnum(thisteam));
		  	v.setThreeShootNumave(cal.getavethreeshootnum(thisteam));
		  	
		  	v.setFreeHitNumave(cal.getavefreehitnum(thisteam));
		  	v.setFreeNumave(cal.getavefreenum(thisteam));
		  	
		  	v.setRebAttNumave(cal.getaverebattnum(thisteam));
		  	v.setRebDefNumave(cal.getaverebdefnum(thisteam));
		  	v.setRebTotalNumave(cal.getaverebtotalnum(thisteam));
		  	
		  	v.setAssistNumave(cal.getaveassistnum(thisteam));
		  	v.setStealNumave(cal.getavestealnum(thisteam));
		  	v.setBlockNumave(cal.getaveblocknum(thisteam));
		  	v.setErrorNumave(cal.getaveerrornum(thisteam));
		  	v.setFoulNumave(cal.getavefoulnum(thisteam));
		  	pa.add(v);//System.out.println("asd");
		}
	}
    public TeamPO getTeamInfo(String name){
    	TeamPO result=new TeamPO();
    	ArrayList<TeamPO> p2=fd.getTeamFundData();
    	for(TeamPO p:p2){
    		if(p.getShortName().equals(name)){
    			result=p;
    			break;
    		}
    	}
    	return result;
    }
	
    //public ArrayList<String> getTeamInOrder(Order order,TeamStandard stan){
    	//return ts.sort(pa, order, stan);
    //}
    
    public HashMap<String,Image> getAllTeam(){
    	return fd.getTeamImage();
    }
    public TeamAllGamePO getoppgamedata(TeamAllGamePO p){
    	ArrayList<TeamGamePO> tgp=p.getGameDataList();
    	ArrayList<TeamGamePO> tgp2=new ArrayList<TeamGamePO>();
    	ArrayList<TeamAllGamePO> po=gd.getTeamGameData();
    	for(TeamGamePO tp:tgp){
    		String[] team=tp.getMatchPair().split("-");
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
    
    public ArrayList<TeamHotInfo> getHotTeam(Field2 field2,int num){
    	ArrayList<TeamHotInfo> h=new ArrayList<TeamHotInfo>();
    	getTeamVO();String fiel="";System.out.println("ger");
    	TeamStandard tst=TeamStandard.allpointave;
    	if(field2==Field2.score){
    		tst=TeamStandard.allpointave;fiel="score";
    	}
    	else if(field2==Field2.rebound){
    		tst=TeamStandard.rebTotalNumave;fiel="rebound";
    	}
    	else if(field2==Field2.assist){
    		tst=TeamStandard.assistNumave;fiel="assist";
    	}
    	else if(field2==Field2.blockShot){
    		tst=TeamStandard.blockNumave;fiel="blockShot";
    	}
    	else if(field2==Field2.steal){
    		tst=TeamStandard.stealNumave;fiel="steal";
    	}
    	else if(field2==Field2.foul){
    		tst=TeamStandard.foulNumave;fiel="foul";
    	}
    	else if(field2==Field2.fault){
    		tst=TeamStandard.errorNumave;fiel="fault";
    	}
    	else if(field2==Field2.shot){
    		tst=TeamStandard.shootrate;fiel="shot";
    	}
    	else if(field2==Field2.three){
    		tst=TeamStandard.threepointrate;fiel="three";
    	}
    	else if(field2==Field2.penalty){
    		tst=TeamStandard.freehitrate;fiel="penalty";
    	}
    	else if(field2==Field2.defendRebound){
    		tst=TeamStandard.rebDefNumave;fiel="defendRebound";
    	}
    	else if(field2==Field2.offendRebound){
    		tst=TeamStandard.rebAttNumave;fiel="offendRebound";
    	}
    	ts.sort(pa, Order.dsec, tst);
    	for(int i=0;i<num;i++){
    		TeamHotInfo hi=new TeamHotInfo();
    		hi.setField(fiel);
    		hi.setLeague(pa.get(i).getCompArea());
    		hi.setTeamName(pa.get(i).getShortName());
    		if(field2==Field2.score){
        		hi.setValue(pa.get(i).getAllpointave());
        	}
        	else if(field2==Field2.rebound){
        		hi.setValue(pa.get(i).getRebTotalNumave());
        	}
        	else if(field2==Field2.assist){
        		hi.setValue(pa.get(i).getAssistNumave());
        	}
        	else if(field2==Field2.blockShot){
        		hi.setValue(pa.get(i).getBlockNumave());
        	}
        	else if(field2==Field2.steal){
        		hi.setValue(pa.get(i).getStealNumave());
        	}
        	else if(field2==Field2.foul){
        		hi.setValue(pa.get(i).getFoulNumave());
        	}
        	else if(field2==Field2.fault){
        		hi.setValue(pa.get(i).getErrorNumave());
        	}
        	else if(field2==Field2.shot){
        		hi.setValue(pa.get(i).getShootrate());
        	}
        	else if(field2==Field2.three){
        		hi.setValue(pa.get(i).getThreepointrate());
        	}
        	else if(field2==Field2.penalty){
        		hi.setValue(pa.get(i).getFreehitrate());
        	}
        	else if(field2==Field2.defendRebound){
        		hi.setValue(pa.get(i).getRebDefNumave());
        	}
        	else if(field2==Field2.offendRebound){
        		hi.setValue(pa.get(i).getRebAttNumave());
        	}
    		h.add(hi);
    	}
    	return h;
    }
    //得到热点球队信息，field2为筛选热门球队的属性，num为返回的球队数
     
     
     
	public ArrayList<TeamHighInfo> getTeamHighInfo(TeamStandard tst,Order order,int num){
		getTeamVO();//System.out.println(pa.size()+"qwer");
		//for(int i=0;i<pa.size();i++){
			//System.out.println(pa.get(i).getWinrate()+"a");
		//}
		ArrayList<TeamHighInfo> h=new ArrayList<TeamHighInfo>();
		ts.sort(pa, order, tst);
		
		for(int i=0;i<num;i++){
			TeamHighInfo thi=new TeamHighInfo();
			thi.setAssistEfficient(pa.get(i).getAssistrate());
			thi.setDefendEfficient(pa.get(i).getDefendrate());
			thi.setDefendReboundEfficient(pa.get(i).getRebdefrate());
			thi.setOffendEfficient(pa.get(i).getAttackrate());
			thi.setOffendReboundEfficient(pa.get(i).getRebattrate());
			thi.setOffendRound(pa.get(i).getAttackround());
			thi.setStealEfficient(pa.get(i).getStealrate());
			thi.setTeamName(pa.get(i).getShortName());
			thi.setWinRate(pa.get(i).getWinrate());
			h.add(thi);
		}
		return h;
	}
	//得到球队高级数据，均为平均值，teamstandard为排序依据，order为升降序，num为要的数目
	
	
	public ArrayList<TeamNormalInfo> getTeamavgNormalInfo(TeamStandard tst,Order order,int num){
		getTeamVO();
		ArrayList<TeamNormalInfo> h=new ArrayList<TeamNormalInfo>();
		ts.sort(pa, order, tst);
		for(int i=0;i<num;i++){
			TeamNormalInfo thi=new TeamNormalInfo();
			thi.setAssist(pa.get(i).getAssistNumave());
			thi.setBlockShot(pa.get(i).getRebTotalNumave());
			thi.setDefendRebound(pa.get(i).getRebDefNumave());
			thi.setFault(pa.get(i).getErrorNumave());
			thi.setFoul(pa.get(i).getFoulNumave());
			thi.setNumOfGame(pa.get(i).getGamenum());
			thi.setOffendRebound(pa.get(i).getRebAttNumave());
			thi.setPenalty(pa.get(i).getFreehitrate());
			thi.setPoint(pa.get(i).getAllpointave());
			thi.setRebound(pa.get(i).getRebTotalNumave());
			thi.setShot(pa.get(i).getShootrate());
			thi.setSteal(pa.get(i).getStealNumave());
			thi.setTeamName(pa.get(i).getShortName());
			thi.setThree(pa.get(i).getThreepointrate());
			h.add(thi);
		}
		return h;
		
	}
	//得到球队基本数据的平均值，ts为排序依据，order为升降序，num为数目
	
	
	public ArrayList<TeamNormalInfo> getTeamTotalNormalInfo(TeamStandard tst,Order order,int num){
		getTeamVO();
		ArrayList<TeamNormalInfo> h=new ArrayList<TeamNormalInfo>();
		ts.sort(pa, order, tst);
		for(int i=0;i<num;i++){
			TeamNormalInfo thi=new TeamNormalInfo();
			thi.setAssist(pa.get(i).getAssistNum());
			thi.setBlockShot(pa.get(i).getRebTotalNum());
			thi.setDefendRebound(pa.get(i).getRebDefNum());
			thi.setFault(pa.get(i).getErrorNum());
			thi.setFoul(pa.get(i).getFoulNum());
			thi.setNumOfGame(pa.get(i).getGamenum());
			thi.setOffendRebound(pa.get(i).getRebAttNum());
			thi.setPenalty(pa.get(i).getFreehitrate());
			thi.setPoint(pa.get(i).getAllpoint());
			thi.setRebound(pa.get(i).getRebTotalNum());
			thi.setShot(pa.get(i).getShootrate());
			thi.setSteal(pa.get(i).getStealNum());
			thi.setTeamName(pa.get(i).getShortName());
			thi.setThree(pa.get(i).getThreepointrate());
			h.add(thi);
		}
		return h;
		
	}
	//得到球队基本数据的总和，ts为排序依据，order为升降序，num为数目
	
	
	
	
	public ArrayList<TeamGamePO> getGameInfo(String time,String matchpair){
		po=gd.getTeamGameData();ArrayList<TeamGamePO> resu=new ArrayList<TeamGamePO>();
		String[] result=matchpair.split("-");
		for(int i=0;i<po.size();i++){
			if(po.get(i).getTeamName().equals(result[0])||po.get(i).getTeamName().equals(result[1])){
				for(int j=0;j<po.get(i).getGameDataList().size();j++){
					if(po.get(i).getGameDataList().get(j).getMatchDate().equals(time)){
						resu.add(po.get(i).getGameDataList().get(j));
						break;
					}
				}
				if(resu.size()==2){
					break;
				}
				
			}
		}
		/*for(int i=0;i<po.size();i++){
			if(po.get(i).getTeamName().equals(result[1])){
				for(int j=0;j<po.get(i).getGameDataList().size();j++){
					if(po.get(i).getGameDataList().get(j).getMatchDate().equals(time)){
						resu.add(po.get(i).getGameDataList().get(j));
						break;
					}
				}
				break;
			}
		}*/
		return resu;
	}
	
	//得到某一场比赛数据
	
	public TeamNormalInfo getSingleTeamNormalInfo(String name){
		getTeamVO();
		TeamNormalInfo thi=new TeamNormalInfo();
		for(int i=0;i<pa.size();i++){
		   if(pa.get(i).getShortName().equals(name)){
		
		     thi.setAssist(pa.get(i).getAssistNumave());
		     thi.setBlockShot(pa.get(i).getRebTotalNumave());
		     thi.setDefendRebound(pa.get(i).getRebDefNumave());
		     thi.setFault(pa.get(i).getErrorNumave());
		     thi.setFoul(pa.get(i).getFoulNumave());
		     thi.setNumOfGame(pa.get(i).getGamenum());
		     thi.setOffendRebound(pa.get(i).getRebAttNumave());
		     thi.setPenalty(pa.get(i).getFreehitrate());
		     thi.setPoint(pa.get(i).getAllpointave());
		     thi.setRebound(pa.get(i).getRebTotalNumave());
		     thi.setShot(pa.get(i).getShootrate());
		     thi.setSteal(pa.get(i).getStealNumave());
		     thi.setTeamName(pa.get(i).getShortName());
		     thi.setThree(pa.get(i).getThreepointrate());
		     break;
		   }
	    }
		return thi;
	}
	//得到一支球队的基本信息，为平均值
	
	public TeamHighInfo getSingleTeamHighInfo(String name){
		getTeamVO();
		TeamHighInfo thi=new TeamHighInfo();
		for(int i=0;i<pa.size();i++){
			System.out.println(pa.get(i).getShortName());
			   if(pa.get(i).getShortName().equals(name)){
				    thi.setAssistEfficient(pa.get(i).getAssistrate());
					thi.setDefendEfficient(pa.get(i).getDefendrate());
					thi.setDefendReboundEfficient(pa.get(i).getRebdefrate());
					thi.setOffendEfficient(pa.get(i).getAttackrate());
					thi.setOffendReboundEfficient(pa.get(i).getRebattrate());
					thi.setOffendRound(pa.get(i).getAttackround());
					thi.setStealEfficient(pa.get(i).getStealrate());
					thi.setTeamName(pa.get(i).getShortName());
					thi.setWinRate(pa.get(i).getWinrate());
			
					
					
					//System.out.println("asd");
			     
			     break;
			   }
		    }
		return thi;
	}
	//得到一支球队的高级数据，为平均值
	public ArrayList<DateGameVO> getRecentGame (String name){
		po=gd.getTeamGameData();ArrayList<DateGameVO> result=new ArrayList<DateGameVO>();
		for(int i=0;i<po.size();i++){
			if(po.get(i).getTeamName().equals(name)){
				for(int j=0;j<5&&j<po.get(i).getGameDataList().size();j++){
					DateGameVO dgv=new DateGameVO();
					dgv.setDate(po.get(i).getGameDataList().get(j).getMatchDate());
					String[] s1=po.get(i).getGameDataList().get(j).getMatchResult().split("-");
					dgv.setScore1(s1[0]);
					dgv.setScore2(s1[1]);
					String[] s2=po.get(i).getGameDataList().get(j).getMatchPair().split("-");
					dgv.setTeam1(s2[0]);
					dgv.setTeam2(s2[1]);
					result.add(dgv);
					
				}
				break;
			}
		}
		return result;
	}
	//得到一支球队的最近5场比赛信息
   /* public TeamInfo getTeamInfo(String team, String date){
    	TeamAllGamePO thisteam=new TeamAllGamePO();
    	TeamAllGamePO oppteam=new TeamAllGamePO();
    	
    	for(TeamAllGamePO p:po){
    		if(p.getTeamName().equals(team)){
    			thisteam=p;
    			break;
    		}
    	}
    	oppteam=getoppgamedata(thisteam);
    	ArrayList<TeamGamePO> thist=new ArrayList<TeamGamePO>();
    	ArrayList<TeamGamePO> oppt=new ArrayList<TeamGamePO>();
    	thist=thisteam.getGameDataList();
    	oppt=oppteam.getGameDataList();
    	TeamGamePO p1=new TeamGamePO();
    	TeamGamePO p2=new TeamGamePO();
    	int ishere=0;
    	for(TeamGamePO tgp:thist){
    		if(tgp.getMatchDate().equals(date)){
    			p1=tgp;
    			ishere=1;
    			break;
    		}
    	}
    	TeamInfo f=null;
    	if(ishere==1){
    	    p2=oppt.get(thist.indexOf(p1));
    	    f=new TeamInfo(p1.getAllPlayerTime(),p1.getRebTotalNum(),p2.getRebTotalNum(),p1.getRebAttNum(),p2.getRebAttNum(),p1.getRebDefNum(),p2.getRebDefNum(),p1.getHitShootNum(),p2.getRebAttNum(),p2.getShootNum()-p2.getThreeShootNum(),p1.getShootNum(),p1.getFreeNum(),p1.getErrorNum());
    	}
    	return f;
    }*/
    /*public String getArea(String teamName){
    	String s="";
    	for(TeamPO p:p2){
    		if(p.getShortName().equals(teamName)){
    			s=p.getCompArea()+"-"+p.getZone();
    			break;
    		}
    	}
    	return s;
    }*/
    /*public static void main(String args[]){
    	TeamController t=new TeamController();
    	for(TeamVO v:t.pa){
    		if(v.getTeamName().equals("BOS")){
    			System.out.println("OK");
    		}
    	}
    	//TeamVO v=t.getTeamInfo("BOS");
    	//System.out.println(v.getAttackround());
    	ArrayList<String> s=t.getTeamInOrder(Order.UP, TeamStandard.allpoint);
    	for(int i=0;i<s.size();i++){
    		System.out.println(s.get(i)+i);
    	}
    	System.out.println(t.getTeamInfo(s.get(29)).getAllpointave());
    }*/
	public ArrayList<DateGameVO> getGamebyDate(String time) {
		// TODO Auto-generated method stub
		po=gd.getTeamGameData();ArrayList<DateGameVO> result=new ArrayList<DateGameVO>();
		//System.out.println(po.size());
		for(int i=0;i<po.size();i++){
			
				for(int j=0;j<po.get(i).getGameDataList().size();j++){
					//System.out.println(po.get(i).getGameDataList().get(j).getMatchDate());
					if(po.get(i).getGameDataList().get(j).getMatchDate().equals(time)){
						//System.out.println("_____");
					   DateGameVO dgv=new DateGameVO();
					   dgv.setDate(po.get(i).getGameDataList().get(j).getMatchDate());
					   String[] s1=po.get(i).getGameDataList().get(j).getMatchResult().split("-");
					   dgv.setScore1(s1[0]);
					   dgv.setScore2(s1[1]);
					   String[] s2=po.get(i).getGameDataList().get(j).getMatchPair().split("-");
					   dgv.setTeam1(s2[0]);
					   dgv.setTeam2(s2[1]);
					   
					   result.add(dgv);
					}
				
			    }
		}
		//for(int i=0;i<result.size();i++){
			//System.out.println(result.get(i).getDate()+result.get(i).getTeam1()+result.get(i).getTeam2());
		//}
		ArrayList<DateGameVO> result2=new ArrayList<DateGameVO>();
		for(int i=0;i<result.size();i++){
			int isExist=0;
			for(int j=i+1;j<result.size();j++){
				if(result.get(j).getDate().equals(result.get(i).getDate())&&result.get(j).getScore1().equals(result.get(i).getScore2())&&result.get(j).getScore2().equals(result.get(i).getScore1())&&result.get(j).getTeam1().equals(result.get(i).getTeam2())&&result.get(j).getTeam2().equals(result.get(i).getTeam1())){
					isExist=1;
					break;
				}
			}
			if(isExist==0){
				result2.add(result.get(i));
			}
		}
		//for(int i=0;i<result2.size();i++){
			//System.out.println(result2.get(i).getDate()+result2.get(i).getTeam1()+result2.get(i).getTeam2());
		//}
		return result2;
	}
	public static void main(String[] args){
		TeamController t=new TeamController();
		//System.out.println("Asd");
		/*ArrayList<TeamHotInfo> as=new ArrayList<TeamHotInfo>();
		as=t.getHotTeam(Field2.assist, 30);
		for(int i=0;i<as.size();i++){
			System.out.println(as.get(i).getField());
			System.out.println(as.get(i).getLeague());
			System.out.println(as.get(i).getTeamName());
			System.out.println(as.get(i).getValue());
			System.out.println("____________");
		}*/
		/*ArrayList<TeamHighInfo> v=new ArrayList<TeamHighInfo>();
		v=t.getTeamHighInfo(TeamStandard.winrate,Order.dsec,30);
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i).getWinRate());
		}
		System.out.println("________________");
		v=t.getTeamHighInfo(TeamStandard.winrate,Order.dsec,30);
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i).getWinRate());
		}*/
		TeamHighInfo h=new TeamHighInfo();
		h=t.getSingleTeamHighInfo("");
		System.out.println(h.getAssistEfficient());
	}

}
