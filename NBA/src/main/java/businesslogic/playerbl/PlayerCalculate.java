package businesslogic.playerbl;

import java.awt.Image;
import java.util.ArrayList;

import data.funddata.FundData;
import data.funddata.FundDataService;
import data.gamedata.GameData;
import data.gamedata.GameDataService;
import data.gamedata.TeamInfo;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.PlayerPO;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.Field;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import vo.PlayerVO;

public class PlayerCalculate {
	
	CalMethod cm;
	ArrayList<PlayerAllGamePO> playerGameList;
	ArrayList<PlayerPO> playerList;
	
	ArrayList<PlayerNInfo> tot_NInfoList;
	ArrayList<PlayerNInfo> avg_NInfoList;
	
	ArrayList<PlayerNormalInfo> tot_normalInfoList;
	ArrayList<PlayerNormalInfo> avg_normalInfoList;
	
	ArrayList<PlayerHighInfo> HInfoList;
	
	ArrayList<PlayerHotInfo> scoreList;
	ArrayList<PlayerHotInfo> rebList;
	ArrayList<PlayerHotInfo> assistList;
	
	ArrayList<PlayerInfo> playerInfoList;
	
	ArrayList<PlayerNormalInfo> todayList;
	ArrayList<PlayerGamePO> todayGameList;
	
	public PlayerCalculate(){
		iniData();
		cm=new CalMethod();
		calAllInfo();
	}
	
	
	/*
	 * 先计算PlayerNormalInfo
	 */
	public void calTotalNormalInfo(){
		tot_NInfoList=new ArrayList<PlayerNInfo>();
		
		int playerListSize=playerInfoList.size();
		if(playerListSize>0){//若球员列表不为空
			String position;
			String league;
			int age;
			double assist;
			double blockShot;
			double defend;
			double efficiency;
			double fault;
			double foul;
			double minute;
			String name;
			int numOfGame;
			double offend;
			//double penalty;
			double point;
			double rebound;
			//double shot;
			int start;
			double steal;
			String teamName;
			//double three;
			int hitShootNum; //投篮命中数
			int shootNum; //投篮出手数
			int threePointNum; //三分命中数
			int threeShootNum; //三分出手数
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				//initialize values
				position=pi.getPosition();
				league="League";
				age=pi.getAge();
				assist=0;
				blockShot=0;
				defend=0;
				efficiency=0;
				fault=0;
				foul=0;
				minute=0;
				name=pi.getName();
				numOfGame=0;
				offend=0;
				//penalty=0;
				point=0;
				rebound=0;
				//shot=0;
				start=0;
				steal=0;
				teamName=pi.getTeamName();
				//three=0;
				hitShootNum=0; //投篮命中数
				shootNum=0; //投篮出手数
				threePointNum=0; //三分命中数
				threeShootNum=0; //三分出手数
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						assist+=pgp.getAssistNum();
						blockShot+=pgp.getBlockNum();
						defend+=pgp.getRebDefNum();
						efficiency=efficiency+cm.calEfficiency(pgp.getRebTotalNum(), pgp.getAssistNum(), 
								pgp.getStealNum(), pgp.getBlockNum(), pgp.getErrorNum(), pgp.getScore(), 
								pgp.getHitShootNum(), pgp.getShootNum(), pgp.getFreeHitNum(), pgp.getFreeNum());
						fault+=pgp.getErrorNum();
						foul+=pgp.getFoulNum();
						minute+=pgp.getTime();//单位:秒
						numOfGame=1;
						offend+=pgp.getRebAttNum();
						point+=pgp.getScore();
						rebound+=pgp.getRebTotalNum();
						if(pgp.isFirst()){
							start+=1;
						}
						steal+=pgp.getStealNum();
						hitShootNum+=pgp.getHitShootNum(); //投篮命中数
						shootNum+=pgp.getShootNum(); //投篮出手数
						threePointNum+=pgp.getThreePointNum(); //三分命中数
						threeShootNum+=pgp.getThreeShootNum(); //三分出手数
					}
				}
				
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setAge(age);
				pni.setAssist(assist);
				pni.setBlockShot(blockShot);
				pni.setDefend(defend);
				pni.setEfficiency(efficiency);
				pni.setFault(fault);
				pni.setFoul(foul);
				pni.setMinute(minute/60);
				pni.setName(name);
				pni.setNumOfGame(numOfGame);
				pni.setOffend(offend);
				pni.setPenalty(cm.calRate(hitShootNum, shootNum));
				pni.setPoint(point);
				pni.setRebound(rebound);
				pni.setShot(cm.calRate(hitShootNum, shootNum));
				pni.setStart(start);
				pni.setSteal(steal);
				pni.setTeamName(teamName);
				pni.setThree(cm.calRate(threePointNum, threeShootNum));
				
				PlayerNInfo info=new  PlayerNInfo(position,league,age,pni);
				tot_NInfoList.add(info);
			}
		}
		
	}
	
	
	/*
	 * 先计算PlayerNormalInfo
	 */
	public void calAvgNormalInfo(){
		avg_NInfoList=new ArrayList<PlayerNInfo>();
		int playerListSize=playerInfoList.size();
		if(playerListSize>0){//若球员列表不为空
			String position;
			String league;
			int age;
			double assist;
			double blockShot;
			double defend;
			double efficiency;
			double fault;
			double foul;
			double minute;
			String name;
			int numOfGame;
			double offend;
			double penalty;
			double point;
			double rebound;
			double shot;
			int start;
			double steal;
			String teamName;
			double three;
			int hitShootNum; //投篮命中数
			int shootNum; //投篮出手数
			int threePointNum; //三分命中数
			int threeShootNum; //三分出手数
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				//initialize values
				position=pi.getPosition();
				league="League";
				age=pi.getAge();
				assist=0;
				blockShot=0;
				defend=0;
				efficiency=0;
				fault=0;
				foul=0;
				minute=0;
				name=pi.getName();
				numOfGame=0;
				offend=0;
				penalty=0;
				point=0;
				rebound=0;
				shot=0;
				start=0;
				steal=0;
				teamName=pi.getTeamName();
				three=0;
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						assist+=pgp.getAssistNum();
						blockShot+=pgp.getBlockNum();
						defend+=pgp.getRebDefNum();
						efficiency=efficiency+cm.calEfficiency(pgp.getRebTotalNum(), pgp.getAssistNum(), 
								pgp.getStealNum(), pgp.getBlockNum(), pgp.getErrorNum(), pgp.getScore(), 
								pgp.getHitShootNum(), pgp.getShootNum(), pgp.getFreeHitNum(), pgp.getFreeNum());
						fault+=pgp.getErrorNum();
						foul+=pgp.getFoulNum();
						minute+=pgp.getTime();//单位:秒
						numOfGame=1;
						offend+=pgp.getRebAttNum();
						point+=pgp.getScore();
						rebound+=pgp.getRebTotalNum();
						if(pgp.isFirst()){
							start+=1;
						}
						steal+=pgp.getStealNum();
						
						hitShootNum=pgp.getHitShootNum(); //投篮命中数
						shootNum=pgp.getShootNum(); //投篮出手数
						threePointNum=pgp.getThreePointNum(); //三分命中数
						threeShootNum=pgp.getThreeShootNum(); //三分出手数
						shot+=cm.calRate(hitShootNum, shootNum);
						penalty+=cm.calRate(hitShootNum, shootNum);
						three+=cm.calRate(threePointNum, threeShootNum);
					}
				}
				
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setAge(age);
				pni.setAssist(assist/gameListSize);
				pni.setBlockShot(blockShot/gameListSize);
				pni.setDefend(defend/gameListSize);
				pni.setEfficiency(efficiency/gameListSize);
				pni.setFault(fault/gameListSize);
				pni.setFoul(foul/gameListSize);
				pni.setMinute(minute/60/gameListSize);
				pni.setName(name);
				pni.setNumOfGame(numOfGame);
				pni.setOffend(offend/gameListSize);
				pni.setPenalty(penalty/gameListSize);
				pni.setPoint(point/gameListSize);
				pni.setRebound(rebound/gameListSize);
				pni.setShot(shot/gameListSize);
				pni.setStart(start);
				pni.setSteal(steal/gameListSize);
				pni.setTeamName(teamName);
				pni.setThree(three/gameListSize);
				
				PlayerNInfo info=new PlayerNInfo(position,league,age,pni);
				avg_NInfoList.add(info);
			}
		}
	}

	
	/*
	 * 获取高阶数据
	 */
	public void calHighInfo(){
		
		HInfoList=new ArrayList<PlayerHighInfo>();
		
		int playerListSize=playerInfoList.size();
		if(playerListSize>0){//若球员列表不为空
			
			String league;
			String name;
			String position;
			String teamName;
			
			int time = 0; //在场时间(分钟:秒)
		    int hitShootNum=0; //投篮命中数
			int threePointNum=0; //三分命中数
			int threeShootNum=0; //三分出手数
			int freeHitNum=0; //罚球命中数
			int freeNum=0; //罚球出手数
			int rebAttNum=0; //进攻篮板数
			int rebDefNum=0; //防守篮板数
			int rebTotalNum=0; //总篮板数
			int assistNum=0;//助攻数
			int stealNum=0;//抢断数
		    int blockNum=0;//盖帽数
		    int errorNum=0;//失误数
		    int foulNum=0;//犯规数
		    
		    int score=0; //个人得分
		    
		    int allPlayerTime=0; //球队所有队员上场时间（单位：秒）
		    int teamRebNum=0; //球队总篮板数
		    int oppTeamRebNum=0; //对手总篮板数
		    int teamAttRebNum=0; //球队总进攻篮板数
		    int oppTeamAttRebNum=0; //对手总进攻篮板数
		    int teamDefRebNum=0; //球队总防守篮板数
		    int oppTeamDefRebNum=0; //对手总防守篮板数
		    int teamHitNum=0; //球队总进球数
		    int oppAttNum=0; //对手进攻次数
		    int oppTwoNum=0; //对手两分球出手次数
		    int twoNum=0; //球员自己两分球出手数（不是球队）
		    int teamThrowNum=0; //球队所有球员总出手次数
		    int teamFreeNum=0; //球队所有球员罚球次数
		    int teamErrorNum=0; //球队所有球员失误次数
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				
				name=pi.getName();
				league="";
				position=pi.getPosition();
				teamName=pi.getTeamName();
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						time += pgp.getTime(); //在场时间(分钟:秒)
					    hitShootNum +=pgp.getHitShootNum(); //投篮命中数
						threePointNum +=pgp.getThreePointNum(); //三分命中数
						threeShootNum +=pgp.getThreeShootNum(); //三分出手数
						freeHitNum +=pgp.getFreeHitNum(); //罚球命中数
						freeNum +=pgp.getFreeNum(); //罚球出手数
						rebAttNum +=pgp.getRebAttNum(); //进攻篮板数
						rebDefNum +=pgp.getRebDefNum(); //防守篮板数
						rebTotalNum +=pgp.getRebTotalNum(); //总篮板数
						assistNum +=pgp.getAssistNum(); //助攻数
						stealNum +=pgp.getStealNum(); //抢断数
					    blockNum +=pgp.getBlockNum(); //盖帽数
					    errorNum +=pgp.getErrorNum(); //失误数
					    foulNum +=pgp.getFoulNum(); //犯规数
					    
					    score +=pgp.getScore(); //个人得分
					    
					    TeamInfo tif=pgp.getTif();
					    allPlayerTime +=tif.getAllPlayerTime(); //球队所有队员上场时间（单位：秒）
					    teamRebNum+=tif.getTeamRebNum(); //球队总篮板数
					    oppTeamRebNum+=tif.getOppTeamRebNum(); //对手总篮板数
					    teamAttRebNum+=tif.getTeamAttRebNum(); //球队总进攻篮板数
					    oppTeamAttRebNum+=tif.getOppTeamAttRebNum(); //对手总进攻篮板数
					    teamDefRebNum+=tif.getTeamDefRebNum(); //球队总防守篮板数
					    oppTeamDefRebNum+=tif.getOppTeamDefRebNum(); //对手总防守篮板数
					    teamHitNum+=tif.getTeamHitNum(); //球队总进球数
					    oppAttNum+=tif.getOppAttNum(); //对手进攻次数
					    oppTwoNum+=tif.getOppTwoNum(); //对手两分球出手次数
					    twoNum+=(pgp.getShootNum()-pgp.getThreeShootNum()); //球员自己两分球出手数（不是球队）
					    teamThrowNum+=tif.getTeamThrowNum(); //球队所有球员总出手次数
					    teamFreeNum+=tif.getTeamFreeNum(); //球队所有球员罚球次数
					    teamErrorNum+=tif.getTeamErrorNum(); //球队所有球员失误次数
					}
				}
				PlayerHighInfo phi=new PlayerHighInfo();
				
				//计算比率
			    double T=cm.calT(time, allPlayerTime);//用于计算的数据T
			    double GMSC=cm.calGmScEfficiency(rebAttNum, rebDefNum, assistNum, stealNum, blockNum, teamErrorNum, foulNum, score, hitShootNum, threeShootNum, freeHitNum, teamFreeNum);//GmSc效率
			    double realHitRate=cm.calRealHitRate(score, threeShootNum, teamFreeNum);//真实命中率
			    double throwRate=cm.calThrowRate(hitShootNum, threeShootNum, threePointNum);//投篮效率
			    double rebRate=cm.calRebRate(rebTotalNum, T, teamRebNum, oppTeamRebNum);//篮板率
			    double attRebRate=cm.calRebRate(rebAttNum, T, teamAttRebNum, oppTeamAttRebNum);//进攻篮板率
			    double defRebRate=cm.calRebRate(rebDefNum, T, teamDefRebNum, oppTeamDefRebNum);//防守篮板率
			    double assistRate=cm.calAssistRate(assistNum, teamHitNum, hitShootNum, T);//助攻率
			    double stealRate=cm.calStealRate(stealNum, oppAttNum, T);//抢断率
			    double blockRate=cm.calBlockRate(blockNum, oppTwoNum, T);//盖帽率
			    double errorRate=cm.calErrorRate(teamErrorNum, twoNum, teamFreeNum);//失误率
			    double usedRate=cm.calUseRate(threeShootNum, freeNum, errorNum, T, teamThrowNum, teamFreeNum, teamErrorNum);//使用率
				
				phi.setAssistEfficient(assistRate);
				phi.setBlockShotEfficient(blockRate);
				phi.setDefendReboundEfficient(defRebRate);
				phi.setFaultEfficient(errorRate);
				phi.setFrequency(usedRate);
				phi.setGmSc(GMSC);
				phi.setLeague(league);
				phi.setName(name);
				phi.setOffendReboundEfficient(attRebRate);
				phi.setPosition(position);
				phi.setRealShot(realHitRate);
				phi.setReboundEfficient(rebRate);
				phi.setShotEfficient(throwRate);
				phi.setStealEfficient(stealRate);
				phi.setTeamName(teamName);
				
				HInfoList.add(phi);
			}	
		}
	}
	
	/*
	 * to get all info include normalInfo & highInfo
	 * 
	 */
	public void calAllInfo(){
		
		tot_NInfoList=new ArrayList<PlayerNInfo>();
		avg_NInfoList=new ArrayList<PlayerNInfo>();
		scoreList=new ArrayList<PlayerHotInfo>();
		rebList=new ArrayList<PlayerHotInfo>();
		assistList=new ArrayList<PlayerHotInfo>();
		tot_normalInfoList=new ArrayList<PlayerNormalInfo>();
		avg_normalInfoList=new ArrayList<PlayerNormalInfo>();
		HInfoList=new ArrayList<PlayerHighInfo>();
		
		int playerListSize=playerInfoList.size();
		System.out.println("size: "+playerListSize);
		if(playerListSize>0){//若球员列表不为空
			String position;
			String league;
			int age;
			double assist;
			double blockShot;
			double defend;
			double efficiency;
			double fault;
			double foul;
			double minute;
			String name;
			int numOfGame;
			double offend;
			double penalty;
			double point;
			double rebound;
			double shot;
			int start;
			double steal;
			String teamName;
			double three;
			
			int time = 0; //在场时间(分钟:秒)
			int shootNum; //投篮出手数
		    int hitShootNum=0; //投篮命中数
			int threePointNum=0; //三分命中数
			int threeShootNum=0; //三分出手数
			int freeHitNum=0; //罚球命中数
			int freeNum=0; //罚球出手数
			int rebAttNum=0; //进攻篮板数
			int rebDefNum=0; //防守篮板数
			int rebTotalNum=0; //总篮板数
			int assistNum=0;//助攻数
			int stealNum=0;//抢断数
		    int blockNum=0;//盖帽数
		    int errorNum=0;//失误数
		    int foulNum=0;//犯规数
		    
		    int score=0; //个人得分
		    
		    int allPlayerTime=0; //球队所有队员上场时间（单位：秒）
		    int teamRebNum=0; //球队总篮板数
		    int oppTeamRebNum=0; //对手总篮板数
		    int teamAttRebNum=0; //球队总进攻篮板数
		    int oppTeamAttRebNum=0; //对手总进攻篮板数
		    int teamDefRebNum=0; //球队总防守篮板数
		    int oppTeamDefRebNum=0; //对手总防守篮板数
		    int teamHitNum=0; //球队总进球数
		    int oppAttNum=0; //对手进攻次数
		    int oppTwoNum=0; //对手两分球出手次数
		    int twoNum=0; //球员自己两分球出手数（不是球队）
		    int teamThrowNum=0; //球队所有球员总出手次数
		    int teamFreeNum=0; //球队所有球员罚球次数
		    int teamErrorNum=0; //球队所有球员失误次数
			
		    double recent_score;
		    double recent_reb;
		    double recent_assist;
		    
		    double score_upgradeRate;
		    double reb_upgradeRate;
		    double assist_upgradeRate;
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				//initialize values
				position=pi.getPosition();
				league="League";
				age=pi.getAge();
				assist=0;
				blockShot=0;
				defend=0;
				efficiency=0;
				fault=0;
				foul=0;
				minute=0;
				name=pi.getName();
				numOfGame=0;
				offend=0;
				penalty=0;
				point=0;
				rebound=0;
				shot=0;
				start=0;
				steal=0;
				teamName=pi.getTeamName();
				three=0;
				
				time = 0; //在场时间(分钟:秒)
				shootNum=0; //投篮出手数
			    hitShootNum=0; //投篮命中数
				threePointNum=0; //三分命中数
				threeShootNum=0; //三分出手数
				freeHitNum=0; //罚球命中数
				freeNum=0; //罚球出手数
				rebAttNum=0; //进攻篮板数
				rebDefNum=0; //防守篮板数
				rebTotalNum=0; //总篮板数
				assistNum=0;//助攻数
				stealNum=0;//抢断数
			    blockNum=0;//盖帽数
			    errorNum=0;//失误数
			    foulNum=0;//犯规数
			    
			    score=0; //个人得分
			    
			    allPlayerTime=0; //球队所有队员上场时间（单位：秒）
			    teamRebNum=0; //球队总篮板数
			    oppTeamRebNum=0; //对手总篮板数
			    teamAttRebNum=0; //球队总进攻篮板数
			    oppTeamAttRebNum=0; //对手总进攻篮板数
			    teamDefRebNum=0; //球队总防守篮板数
			    oppTeamDefRebNum=0; //对手总防守篮板数
			    teamHitNum=0; //球队总进球数
			    oppAttNum=0; //对手进攻次数
			    oppTwoNum=0; //对手两分球出手次数
			    twoNum=0; //球员自己两分球出手数（不是球队）
			    teamThrowNum=0; //球队所有球员总出手次数
			    teamFreeNum=0; //球队所有球员罚球次数
			    teamErrorNum=0; //球队所有球员失误次数
			    
			    recent_score=0;
			    recent_reb=0;
			    recent_assist=0;
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						if(j<=5){
							recent_score+=pgp.getScore();
							recent_reb+=pgp.getRebTotalNum();
							recent_assist+=pgp.getAssistNum();
						}
						
						assist+=pgp.getAssistNum();
						blockShot+=pgp.getBlockNum();
						defend+=pgp.getRebDefNum();
						efficiency=efficiency+cm.calEfficiency(pgp.getRebTotalNum(), pgp.getAssistNum(), 
								pgp.getStealNum(), pgp.getBlockNum(), pgp.getErrorNum(), pgp.getScore(), 
								pgp.getHitShootNum(), pgp.getShootNum(), pgp.getFreeHitNum(), pgp.getFreeNum());
						fault+=pgp.getErrorNum();
						foul+=pgp.getFoulNum();
						minute+=pgp.getTime();//单位:秒
						numOfGame=1;
						offend+=pgp.getRebAttNum();
						point+=pgp.getScore();
						rebound+=pgp.getRebTotalNum();
						if(pgp.isFirst()){
							start+=1;
						}
						steal+=pgp.getStealNum();
						time += pgp.getTime(); //在场时间(分钟:秒)
						shootNum+=pgp.getShootNum(); //投篮出手数
					    hitShootNum +=pgp.getHitShootNum(); //投篮命中数
						threePointNum +=pgp.getThreePointNum(); //三分命中数
						threeShootNum +=pgp.getThreeShootNum(); //三分出手数
						freeHitNum +=pgp.getFreeHitNum(); //罚球命中数
						freeNum +=pgp.getFreeNum(); //罚球出手数
						rebAttNum +=pgp.getRebAttNum(); //进攻篮板数
						rebDefNum +=pgp.getRebDefNum(); //防守篮板数
						rebTotalNum +=pgp.getRebTotalNum(); //总篮板数
						assistNum +=pgp.getAssistNum(); //助攻数
						stealNum +=pgp.getStealNum(); //抢断数
					    blockNum +=pgp.getBlockNum(); //盖帽数
					    errorNum +=pgp.getErrorNum(); //失误数
					    foulNum +=pgp.getFoulNum(); //犯规数
					    
					    score +=pgp.getScore(); //个人得分
					    
					    TeamInfo tif=pgp.getTif();
					    allPlayerTime +=tif.getAllPlayerTime(); //球队所有队员上场时间（单位：秒）
					    System.out.println("allplayerTime:"+tif.getAllPlayerTime());
					    teamRebNum+=tif.getTeamRebNum(); //球队总篮板数
					    System.out.println("all:"+tif.getTeamRebNum());
					    oppTeamRebNum+=tif.getOppTeamRebNum(); //对手总篮板数
					    teamAttRebNum+=tif.getTeamAttRebNum(); //球队总进攻篮板数
					    oppTeamAttRebNum+=tif.getOppTeamAttRebNum(); //对手总进攻篮板数
					    teamDefRebNum+=tif.getTeamDefRebNum(); //球队总防守篮板数
					    oppTeamDefRebNum+=tif.getOppTeamDefRebNum(); //对手总防守篮板数
					    teamHitNum+=tif.getTeamHitNum(); //球队总进球数
					    oppAttNum+=tif.getOppAttNum(); //对手进攻次数
					    oppTwoNum+=tif.getOppTwoNum(); //对手两分球出手次数
					    twoNum+=(pgp.getShootNum()-pgp.getThreeShootNum()); //球员自己两分球出手数（不是球队）
					    teamThrowNum+=tif.getTeamThrowNum(); //球队所有球员总出手次数
					    teamFreeNum+=tif.getTeamFreeNum(); //球队所有球员罚球次数
					    teamErrorNum+=tif.getTeamErrorNum(); //球队所有球员失误次数
					}
				}
				
				//total info
				PlayerNormalInfo t_pni=new PlayerNormalInfo();
				t_pni.setAge(age);
				t_pni.setAssist(assist);
				t_pni.setBlockShot(blockShot);
				t_pni.setDefend(defend);
				t_pni.setEfficiency(efficiency);
				t_pni.setFault(fault);
				t_pni.setFoul(foul);
				t_pni.setMinute(minute/60);
				t_pni.setName(name);
				t_pni.setNumOfGame(numOfGame);
				t_pni.setOffend(offend);
				t_pni.setPenalty(cm.calRate(hitShootNum, shootNum));
				t_pni.setPoint(point);
				t_pni.setRebound(rebound);
				t_pni.setShot(cm.calRate(hitShootNum, shootNum));
				t_pni.setStart(start);
				t_pni.setSteal(steal);
				t_pni.setTeamName(teamName);
				t_pni.setThree(cm.calRate(threePointNum, threeShootNum));
				PlayerNInfo t_info=new  PlayerNInfo(position,league,age,t_pni);
				tot_normalInfoList.add(t_pni);
				tot_NInfoList.add(t_info);
				
				//avg info
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setAge(age);
				pni.setAssist(assist/gameListSize);
				pni.setBlockShot(blockShot/gameListSize);
				pni.setDefend(defend/gameListSize);
				pni.setEfficiency(efficiency/gameListSize);
				pni.setFault(fault/gameListSize);
				pni.setFoul(foul/gameListSize);
				pni.setMinute(minute/60/gameListSize);
				pni.setName(name);
				pni.setNumOfGame(numOfGame);
				pni.setOffend(offend/gameListSize);
				pni.setPenalty(cm.calRate(hitShootNum, shootNum));
				pni.setPoint(point/gameListSize);
				pni.setRebound(rebound/gameListSize);
				pni.setShot(cm.calRate(hitShootNum, shootNum));
				pni.setStart(start);
				pni.setSteal(steal/gameListSize);
				pni.setTeamName(teamName);
				pni.setThree(cm.calRate(threePointNum, threeShootNum));
				PlayerNInfo info=new PlayerNInfo(position,league,age,pni);
				avg_normalInfoList.add(pni);
				avg_NInfoList.add(info);
				
				//high info
				PlayerHighInfo phi=new PlayerHighInfo();
			    double T=cm.calT(time, allPlayerTime);//用于计算的数据T
			    System.out.println(">>>>>>>>>>>>>>cal T: "+time+" "+allPlayerTime);
			    double GMSC=cm.calGmScEfficiency(rebAttNum, rebDefNum, assistNum, stealNum, blockNum, teamErrorNum, foulNum, score, hitShootNum, threeShootNum, freeHitNum, teamFreeNum);//GmSc效率
			    double realHitRate=cm.calRealHitRate(score, threeShootNum, teamFreeNum);//真实命中率
			    double throwRate=cm.calThrowRate(hitShootNum, threeShootNum, threePointNum);//投篮效率
			    double rebRate=cm.calRebRate(rebTotalNum, T, teamRebNum, oppTeamRebNum);//篮板率
			    double attRebRate=cm.calRebRate(rebAttNum, T, teamAttRebNum, oppTeamAttRebNum);//进攻篮板率
			    double defRebRate=cm.calRebRate(rebDefNum, T, teamDefRebNum, oppTeamDefRebNum);//防守篮板率
			    double assistRate=cm.calAssistRate(assistNum, teamHitNum, hitShootNum, T);//助攻率
			    double stealRate=cm.calStealRate(stealNum, oppAttNum, T);//抢断率
			    System.out.println(">>>>>>>>>>>>>>cal: "+stealNum+" "+oppAttNum+" "+T);
			    double blockRate=cm.calBlockRate(blockNum, oppTwoNum, T);//盖帽率
			    double errorRate=cm.calErrorRate(teamErrorNum, twoNum, teamFreeNum);//失误率
			    double usedRate=cm.calUseRate(threeShootNum, freeNum, errorNum, T, teamThrowNum, teamFreeNum, teamErrorNum);//使用率
				phi.setAssistEfficient(assistRate);
				phi.setBlockShotEfficient(blockRate);
				phi.setDefendReboundEfficient(defRebRate);
				phi.setFaultEfficient(errorRate);
				phi.setFrequency(usedRate);
				phi.setGmSc(GMSC);
				phi.setLeague(league);
				phi.setName(name);
				phi.setOffendReboundEfficient(attRebRate);
				phi.setPosition(position);
				phi.setRealShot(realHitRate);
				phi.setReboundEfficient(rebRate);
				phi.setShotEfficient(throwRate);
				phi.setStealEfficient(stealRate);
				System.out.println(">>>>>>>>>>>>>>set: "+phi.getStealEfficient());
				phi.setTeamName(teamName);
				HInfoList.add(phi);
				
				//hot info
				if(gameListSize>5){
					if(recent_score==0){
						score_upgradeRate=0;
					}else{
						double d_score=(point-recent_score)/(gameListSize-5);
						if(d_score==0){
							score_upgradeRate=0;
						}else{
							score_upgradeRate=( (recent_score/5)/d_score )-1;
						}
					}
					
					if(recent_reb==0){
						reb_upgradeRate=0;
					}else{
						double d_reb=(point-recent_score)/(gameListSize-5);
						if(d_reb==0){
							reb_upgradeRate=0;
						}else{
							reb_upgradeRate=( (recent_reb/5)/d_reb )-1;
						}
					}
					
					if(recent_assist==0){
						assist_upgradeRate=0;
					}else{
						double d_assist=(assist-recent_assist)/(gameListSize-5);
						if(d_assist==0){
							assist_upgradeRate=0;
						}else{
							assist_upgradeRate=( (recent_assist/5)/d_assist )-1;
						}
					}
				}else{
					score_upgradeRate=0;
					reb_upgradeRate=0;
					assist_upgradeRate=0;
				}
				
				PlayerHotInfo ph1=new PlayerHotInfo();
				ph1.setName(name);
				ph1.setPosition(position);
				ph1.setTeamName(teamName);
				ph1.setField("score");
				ph1.setUpgradeRate(score_upgradeRate);
				ph1.setValue(point/gameListSize);
				scoreList.add(ph1);
				
				PlayerHotInfo ph2=new PlayerHotInfo();
				ph2.setName(name);
				ph2.setPosition(position);
				ph2.setTeamName(teamName);
				ph2.setField("rebound");
				ph2.setUpgradeRate(reb_upgradeRate);
				ph2.setValue(rebTotalNum/gameListSize);
				rebList.add(ph2);
				
				PlayerHotInfo ph3=new PlayerHotInfo();
				ph3.setName(name);
				ph3.setPosition(position);
				ph3.setTeamName(teamName);
				ph3.setField("assist");
				ph3.setUpgradeRate(assist_upgradeRate);
				ph3.setValue(assistNum/gameListSize);
				assistList.add(ph3);
			}
		}
	}
	
	
	/*
	 * 过滤操作
	 * 取得满足对应属性的球员信息
	 */
	public ArrayList<PlayerNormalInfo> filterNormal(ArrayList<PlayerNInfo> plist,Position pos,
			League lea,Age age){
		ArrayList<PlayerNInfo> list=plist;
		ArrayList<PlayerNormalInfo> result=new ArrayList<PlayerNormalInfo>();
		for(int i=0;i<list.size();i++){
			
			PlayerNInfo pni=list.get(i);
			
			String position=pos.toString();
			String league=lea.toString();
			String ag=age.toString();
			boolean match=true;
			
			if(!league.equals("All")){
				if(!pni.getLeague().equals(league)){
					match=false;
					continue;
				}
			}
			if(!position.equals("All")){
				if(!pni.getPosition().equals(position)){
					match=false;
					continue;
				}
			}
			if(!ag.equals("All")){
				int n=pni.getAge();
				if(ag.equals("lv1")){
					if(n>22||n<=0){
						match=false;
						continue;
					}
				}else if(ag.equals("lv2")){
					if(n<=22||n>25){
						match=false;
						continue;
					}
				}else if(ag.equals("lv3")){
					if(n<=25||n>30){
						match=false;
						continue;
					}
				}else if(ag.equals("lv4")){
					if(n<=30){
						match=false;
						continue;
					}
				}
			}
			if(match){
				PlayerNormalInfo info=pni.getPni();
				result.add(info);
			}
		}
		return result;
	}
	
	
	
	public ArrayList<PlayerNormalInfo> sortNormal(ArrayList<PlayerNormalInfo> list,
			PlayerStandard ps,Order order){
		SortNormalInfo sortMethod=new SortNormalInfo();
		ArrayList<PlayerNormalInfo> temp=list;
		sortMethod.sort(temp,order,ps);
		return temp;
	}
	
	public ArrayList<PlayerNormalInfo> sortNormalMultiOrder(PlayerStandard ps,Order order,int num){
		
		return null;
	}
	
	public ArrayList<PlayerHighInfo> sortHigh(ArrayList<PlayerHighInfo> list,
			PlayerStandard ps,Order order){
		SortHighInfo sortMethod=new SortHighInfo();
		ArrayList<PlayerHighInfo> temp=list;
		sortMethod.sort(temp,order,ps);
		return temp;
	}
	
	/*
	 * 获取球员赛季高阶数据
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerHighInfo>
	 */
	public ArrayList<PlayerHighInfo> getPlayerHighInfo(PlayerStandard ps,Order order,int num){
		if(HInfoList==null){
			calHighInfo();
		}
		ArrayList<PlayerHighInfo> result=new ArrayList<PlayerHighInfo>();
		sortHigh(HInfoList,ps,order);
		for(int i=0;i<HInfoList.size();i++){
			System.out.println(HInfoList.get(i).getName()+" "+HInfoList.get(i).getStealEfficient());
		}
		if(num>=HInfoList.size()){
			for(int i=0;i<HInfoList.size();i++){
				result.add(HInfoList.get(i));
			}
			return result;
		}else{
			for(int i=0;i<num;i++){
				result.add(HInfoList.get(i));
			}
			return result;
		}
	}
	
	/*
	 * 获取球员赛季 平均 基本数据
	 * @param pos 筛选条件：位置
	 * @param lea 筛选条件：赛区
	 * @param age 筛选条件：年龄
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerNormalInfo>
	 */
	public ArrayList<PlayerNormalInfo> getPlayerAvgNormalInfo(Position pos,League lea,Age age,
			PlayerStandard ps,Order order,int num){
		if(avg_NInfoList==null){
			calAllInfo();
		}
		ArrayList<PlayerNormalInfo> tempList=filterNormal(avg_NInfoList,pos,lea,age);
		sortNormal(tempList,ps,order);
		ArrayList<PlayerNormalInfo> result=new ArrayList<PlayerNormalInfo>();
		if(num>=tempList.size()){
			for(int i=0;i<tempList.size();i++){
				result.add(tempList.get(i));
			}
			return result;
		}else{
			for(int i=0;i<num;i++){
				result.add(tempList.get(i));
			}
			return result;
		}
	}
	
	/*
	 * 获取球员赛季 总和 基本数据
	 * @param pos 筛选条件：位置
	 * @param lea 筛选条件：赛区
	 * @param age 筛选条件：年龄
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerNormalInfo>
	 */
	public ArrayList<PlayerNormalInfo> getPlayerTotalNormalInfo(Position pos,League lea,Age age,
			PlayerStandard ps,Order order,int num){
		if(tot_NInfoList==null){
			calAllInfo();
		}
		ArrayList<PlayerNormalInfo> tempList=filterNormal(tot_NInfoList,pos,lea,age);
		sortNormal(tempList,ps,order);
		ArrayList<PlayerNormalInfo> result=new ArrayList<PlayerNormalInfo>();
		if(num>=tempList.size()){
			for(int i=0;i<tempList.size();i++){
				result.add(tempList.get(i));
			}
			return result;
		}else{
			for(int i=0;i<num;i++){
				result.add(tempList.get(i));
			}
			return result;	
		}
	}
	
	
	/*
	 * 获取球员基本信息，如身高体重、照片等
	 * @param name:球员名
	 * @return PlayerVO
	 */
	public PlayerVO getPlayerInfo(String name){
		FundDataService fd=new FundData();
		playerList=fd.getPlayerFundData();
		PlayerPO pp=null;
		for(int i=0;i<playerList.size();i++){
			pp=playerList.get(i);
			if(pp.getName().equals(name)){
				break;
			}
		}
		if(pp!=null){
			String na=pp.getName();
			String team=null;
			String number=pp.getNumber();
			String position=pp.getPosition();
			String height=pp.getHeight();
			String weight=pp.getWeight();
			String birth=pp.getBirth();
			String age=pp.getAge();
			String exp=pp.getExp();
			String school=pp.getSchool();
			Image pic=pp.getPortaitImage();
			Image action=pp.getActionImage();
			PlayerVO result=new PlayerVO(na, team, number, position,
					height, weight, birth, age, exp, school, pic, action);
			return result;
		}else{
			return null;
		}
	}
	
	
	
	public PlayerNormalInfo getSinglePlayerNormalInfo(String name){
		if(avg_NInfoList==null){
			calAvgNormalInfo();
		}
		for(int i=0;i<avg_NInfoList.size();i++){
			PlayerNormalInfo pni=avg_NInfoList.get(i).getPni();
			if(pni.getName().equals(name)){
				return pni;
			}
		}
		return null;
	}
	
	public PlayerHighInfo getSinglePlayerHighInfo(String name){
		if(HInfoList==null){
			calHighInfo();
		}
		for(int i=0;i<HInfoList.size();i++){
			PlayerHighInfo phi=new PlayerHighInfo();
			if(phi.getName().equals(name)){
				return phi;
			}
		}
		return null;
	}
	
	/*
	 * 获取进步最快球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerHotInfo>
	 */
	public ArrayList<PlayerHotInfo> getHotPlayer(Field field,int num){
		ArrayList<PlayerHotInfo> result = null;
		if(field.toString().equals("score")){
			System.out.println("scr");
			if(scoreList!=null){
				//sort
				System.out.println("scr-sort");
				UpgradeRateDSort urs=new UpgradeRateDSort();
				urs.quicksort(scoreList);
				if(num>=scoreList.size()){
					result=scoreList;
					return result;
				}else{
					result=new ArrayList<PlayerHotInfo>();
					for(int i=0;i<num;i++){
						result.add(scoreList.get(i));
					}
					return result;
				}
			}
		}else if(field.toString().equals("rebound")){
			System.out.println("reb");
			if(rebList!=null){
				//sort
				UpgradeRateDSort urs=new UpgradeRateDSort();
				urs.quicksort(rebList);
				if(num>=rebList.size()){
					result=rebList;
					return result;
				}else{
					result=new ArrayList<PlayerHotInfo>();
					for(int i=0;i<num;i++){
						result.add(rebList.get(i));
					}
					return result;
				}
			}
		}else if(field.toString().equals("assist")){
			System.out.println("ass");
			if(assistList!=null){
				//sort
				UpgradeRateDSort urs=new UpgradeRateDSort();
				urs.quicksort(assistList);
				if(num>=assistList.size()){
					result=assistList;
					return result;
				}else{
					result=new ArrayList<PlayerHotInfo>();
					for(int i=0;i<num;i++){
						result.add(assistList.get(i));
					}
					return result;
				}
			}
		}
		return null;
	}
	
	
	/*
	 * 获取赛季热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getSeasonKingPlayer(Field field,int num){
		ArrayList<PlayerKingInfo> result=new ArrayList<PlayerKingInfo>();
		SortNormalInfo sni=new SortNormalInfo();
		if(field==Field.score){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.score);
		}else if(field==Field.block){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.blockNum);
		}else if(field==Field.assist){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.assistNum);
		}else if(field==Field.rebound){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.rebTotalNum);
		}else if(field==Field.steal){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.stealNum);
		}else if(field==Field.three){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.threeRate);
		}else if(field==Field.free){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.freeRate);
		}else if(field==Field.shoot){
			sni.sort(avg_normalInfoList, Order.dsec, PlayerStandard.shooting);
		}
		if(num>=avg_normalInfoList.size()){
			for(int i=0;i<avg_normalInfoList.size();i++){
				PlayerNormalInfo pni=avg_normalInfoList.get(i);
				PlayerKingInfo pki=new PlayerKingInfo();
				
				
				String name=pni.getName();
				
				pki.setField(field.toString());
				pki.setName(name);
				
				PlayerInfo pi = null;
				for(int j=0;j<playerInfoList.size();j++){
					pi=playerInfoList.get(j);
					if(pi.getName().equals(name)){
						break;
					}
				}
				pki.setPosition(pi.getPosition());
				pki.setTeamName(pi.getTeamName());
				
				
				if(field==Field.score){
					pki.setValue(pni.getPoint());
				}else if(field==Field.block){
					pki.setValue(pni.getBlockShot());
				}else if(field==Field.assist){
					pki.setValue(pni.getAssist());
				}else if(field==Field.rebound){
					pki.setValue(pni.getRebound());
				}else if(field==Field.steal){
					pki.setValue(pni.getSteal());
				}else if(field==Field.three){
					pki.setValue(pni.getThree());
				}else if(field==Field.free){
					pki.setValue(pni.getPenalty());
				}else if(field==Field.shoot){
					pki.setValue(pni.getShot());
				}
				result.add(pki);
			}
			return result;
		}else{
			for(int i=0;i<num;i++){
				PlayerNormalInfo pni=avg_normalInfoList.get(i);
				PlayerKingInfo pki=new PlayerKingInfo();
				
				
				String name=pni.getName();
				
				pki.setField(field.toString());
				pki.setName(name);
				
				PlayerInfo pi = null;
				for(int j=0;j<playerInfoList.size();j++){
					pi=playerInfoList.get(j);
					if(pi.getName().equals(name)){
						break;
					}
				}
				pki.setPosition(pi.getPosition());
				pki.setTeamName(pi.getTeamName());
				if(field==Field.score){
					pki.setValue(pni.getPoint());
				}else if(field==Field.block){
					pki.setValue(pni.getBlockShot());
				}else if(field==Field.assist){
					pki.setValue(pni.getAssist());
				}else if(field==Field.rebound){
					pki.setValue(pni.getRebound());
				}else if(field==Field.steal){
					pki.setValue(pni.getSteal());
				}else if(field==Field.three){
					pki.setValue(pni.getThree());
				}else if(field==Field.free){
					pki.setValue(pni.getPenalty());
				}else if(field==Field.shoot){
					pki.setValue(pni.getShot());
				}
				result.add(pki);
			}
			return result;
		}
	}
	
	
	/*
	 * 获取当天热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getDailyKingPlayer(Field field,int num){
		calTodayData();
		ArrayList<PlayerKingInfo> result=new ArrayList<PlayerKingInfo>();
		SortNormalInfo sni=new SortNormalInfo();
		if(field==Field.score){
			sni.sort(todayList, Order.dsec, PlayerStandard.score);
		}else if(field==Field.block){
			sni.sort(todayList, Order.dsec, PlayerStandard.blockNum);
		}else if(field==Field.assist){
			sni.sort(todayList, Order.dsec, PlayerStandard.assistNum);
		}else if(field==Field.rebound){
			sni.sort(todayList, Order.dsec, PlayerStandard.rebTotalNum);
		}else if(field==Field.steal){
			sni.sort(todayList, Order.dsec, PlayerStandard.stealNum);
		}
		if(num>=todayList.size()){
			for(int i=0;i<todayList.size();i++){
				PlayerNormalInfo pni=todayList.get(i);
				PlayerKingInfo pki=new PlayerKingInfo();
				
				
				String name=pni.getName();
				
				pki.setField(field.toString());
				pki.setName(name);
				
				PlayerInfo pi = null;
				for(int j=0;j<playerInfoList.size();j++){
					pi=playerInfoList.get(j);
					if(pi.getName().equals(name)){
						break;
					}
				}
				pki.setPosition(pi.getPosition());
				pki.setTeamName(pi.getTeamName());
				
				
				if(field==Field.score){
					pki.setValue(pni.getPoint());
				}else if(field==Field.block){
					pki.setValue(pni.getBlockShot());
				}else if(field==Field.assist){
					pki.setValue(pni.getAssist());
				}else if(field==Field.rebound){
					pki.setValue(pni.getRebound());
				}else if(field==Field.steal){
					pki.setValue(pni.getSteal());
				}
				result.add(pki);
			}
			return result;
		}else{
			for(int i=0;i<num;i++){
				PlayerNormalInfo pni=todayList.get(i);
				PlayerKingInfo pki=new PlayerKingInfo();
				
				String name=pni.getName();
				
				pki.setField(field.toString());
				pki.setName(name);
				
				PlayerInfo pi = null;
				for(int j=0;j<playerInfoList.size();j++){
					pi=playerInfoList.get(j);
					if(pi.getName().equals(name)){
						break;
					}
				}
				pki.setPosition(pi.getPosition());
				pki.setTeamName(pi.getTeamName());
				if(field==Field.score){
					pki.setValue(pni.getPoint());
				}else if(field==Field.block){
					pki.setValue(pni.getBlockShot());
				}else if(field==Field.assist){
					pki.setValue(pni.getAssist());
				}else if(field==Field.rebound){
					pki.setValue(pni.getRebound());
				}else if(field==Field.steal){
					pki.setValue(pni.getSteal());
				}
				result.add(pki);
			}
			return result;
		}
	}
	
	public void getTodayGame(){
		//ini data
		GameDataService gds=new GameData();
		todayGameList=gds.get_Latest_PlayerGameData();
	}
	
	public void calTodayData(){
		
		if(todayList!=null){
			return;
		}else{
			todayList=new ArrayList<PlayerNormalInfo>();
			if(todayGameList==null){
				getTodayGame();
				}
			for(int i=0;i<todayGameList.size();i++){
				PlayerGamePO po=todayGameList.get(i);
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setName(po.getPlayerName());
				pni.setPoint(po.getScore());
				pni.setRebound(po.getRebTotalNum());
				pni.setAssist(po.getAssistNum());
				pni.setSteal(po.getStealNum());
				pni.setBlockShot(po.getBlockNum());
				todayList.add(pni);
				}
		}
	}
	
	/*
	 * iniData()初始化数据
	 * 匹配基本信息与比赛信息
	 * 结果存储于ArrayList<PlayerAllGamePO> gameList中
	 */
	public void iniData(){
		playerInfoList=new ArrayList<PlayerInfo>();
		GameDataService gds=new GameData();
		playerGameList=gds.getPlayerGameData();
		FundDataService fd=new FundData();
		ArrayList<PlayerPO> temp_playerList = fd.getPlayerFundData();
		
		int playerListSize=playerGameList.size();
		for(int i=0;i<playerListSize;i++){//对每一个参赛的选手
			
			boolean isExist=false;
			
			PlayerAllGamePO pag=playerGameList.get(i);
			String pagName=pag.getPlayerName();
			String teamName=pag.getTeamName();
			ArrayList<PlayerGamePO> gameDataList=pag.getGameDataList();
			
			for(int j=0;j<temp_playerList.size();j++){//匹配其基本信息
				
				PlayerPO p=temp_playerList.get(j);
				String pName=p.getName();
				if(pagName.equals(pName)){
					String position=p.getPosition();
					int age=Integer.parseInt(p.getAge());
					PlayerInfo pi=new PlayerInfo(pagName, position, age, teamName, gameDataList);
					playerInfoList.add(pi);
					
					temp_playerList.remove(j);
					isExist=true;
					break;
				}
				
			}
			if(!isExist){//若无基本信息与其匹配
				String position=gameDataList.get(0).getPosition();
				PlayerInfo pi=new PlayerInfo(pagName, position, -1, teamName, gameDataList);
				playerInfoList.add(pi);
			}
			
		}
	}
	
}

